package sysu.lulp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sysu.lulp.mapper.RoleMapper;
import sysu.lulp.pojo.Role;
import sysu.lulp.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }


    @Override
    public Role selectById(int id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}

