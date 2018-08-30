package cn.kgc.service.impl;

import cn.kgc.mapper.RoleMapper;
import cn.kgc.po.Role;
import cn.kgc.service.intf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: RoleServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 10:48
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryAllRoles() {
        return roleMapper.getRoles();
    }

    @Override
    public Role queryRoleById(Integer id) {
        return roleMapper.getRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateRole(role);
    }
    @Override
    public void deleteRole(Integer id) {
        roleMapper.deleteRole(id);
    }
    @Override
    public void addRole(Role role) {
        roleMapper.addRole(role);
    }
}
