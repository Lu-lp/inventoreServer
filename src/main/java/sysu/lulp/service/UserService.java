package sysu.lulp.service;

import sysu.lulp.pojo.SysUser;

import java.util.List;

public interface UserService {

    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user) ;

    public void deleteUser(int id);

    public SysUser queryByName(String username);

    public SysUser queryById(int id);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> getAllUsers();
}
