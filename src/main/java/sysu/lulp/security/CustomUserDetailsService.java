package sysu.lulp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.pojo.UserRole;
import sysu.lulp.service.impl.RoleServiceImpl;
import sysu.lulp.service.impl.UserRoleServiceImpl;
import sysu.lulp.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

@Service("UserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRoleServiceImpl userRoleService;

    private final RoleServiceImpl roleService;

    private final UserServiceImpl userService;

    @Autowired
    public CustomUserDetailsService(UserRoleServiceImpl userRoleService, RoleServiceImpl roleService, UserServiceImpl userService) {
        this.userRoleService = userRoleService;
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = userService.queryByName(s);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        UserRole userRole = userRoleService.queryByUserId(user.getUserId());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(roleService.selectById(userRole.getRoleId()).getRoleName()));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
