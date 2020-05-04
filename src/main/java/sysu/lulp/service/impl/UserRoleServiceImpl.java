package sysu.lulp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.mapper.UserRoleMapper;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.pojo.UserRole;
import sysu.lulp.service.UserRoleService;
import tk.mybatis.mapper.entity.Example;

@Service
public class UserRoleServiceImpl  implements UserRoleService {
    private final UserRoleMapper userRoleMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public UserRole queryByUserId(int id) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userId",id);
        return userRoleMapper.selectOneByExample(example);
    }

    @Override
    public void saveUserRole(UserRole userRole) throws Exception {
        userRoleMapper.insert(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userId",userRole.getUserId());
        userRoleMapper.updateByExampleSelective(userRole,example);
    }

    @Override
    public void deleteUserRole(UserRole userRole) {
        Example example = new Example(UserRole.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("userId",userRole.getUserId());
        userRoleMapper.deleteByExample(example);
    }
}
