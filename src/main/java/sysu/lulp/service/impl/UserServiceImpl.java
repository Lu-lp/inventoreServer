package sysu.lulp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.controller.LoginController;
import sysu.lulp.mapper.SysUserMapper;
import sysu.lulp.pojo.SysUser;
import sysu.lulp.service.UserService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final SysUserMapper userMapper;

    @Autowired
    public UserServiceImpl(SysUserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(SysUser user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysUser queryByName(String username) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria=example.createCriteria();
        criteria.andEqualTo("username",username);

        List<SysUser> result = userMapper.selectByExample(example);
        if(result != null && result.size() != 0) {
            logger.debug("获取用户[{}]成功，密码[{}]",result.get(0).getUsername(),result.get(0).getPassword());
            return result.get(0);
        }else{
            return null;
        }
    }

    @Override
    public SysUser queryById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        return userMapper.selectByExample(user);
    }

    @Override
    public List<SysUser> getAllUsers() {
        return userMapper.selectAll();
    }
}
