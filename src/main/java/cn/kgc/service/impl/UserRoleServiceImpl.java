package cn.kgc.service.impl;

import cn.kgc.mapper.UserRoleMapper;
import cn.kgc.po.Role;
import cn.kgc.po.User;
import cn.kgc.po.UserRole;
import cn.kgc.service.intf.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: UserRoleServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 15:25
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRole> queryAllUserRoles() {
        return userRoleMapper.getUserRoles();
    }

    @Override
    public UserRole queryUserRoleById(Integer id) {
        return userRoleMapper.getUserRoleById(id);
    }

    @Override
    public void updateUserRole(UserRole role) {
        userRoleMapper.updateUserRole(role);
    }

    @Override
    public void deleteUserRole(Integer id) {
        userRoleMapper.deleteUserRole(id);
    }

    @Override
    public List<Role> getRole(Integer userId) {
        List<Integer> roleIds = userRoleMapper.getRoleId(userId);
        //如果该用户没有授权,会出现NOT IN的异常，添加一个-1
        roleIds.add(-1);
        List<Role> roles = userRoleMapper.getRole(roleIds);
        return roles;
    }

    @Override
    public void addRolesToUser(Integer userId, Integer[] roleIds) {
        UserRole userRole = new UserRole();
        Role role = new Role();
        User user = new User();
        userRole.setRole(role);
        userRole.setUser(user);
        for (int i=0;i<roleIds.length;i++){
            userRole.getRole().setId(roleIds[i]);
            userRole.getUser().setId(userId);
            userRoleMapper.addRoleToUser(userRole);
        }
    }
}
