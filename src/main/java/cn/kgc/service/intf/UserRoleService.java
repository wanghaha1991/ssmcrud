package cn.kgc.service.intf;

import cn.kgc.po.Role;
import cn.kgc.po.UserRole;

import java.util.List;

/**
 * @author asus
 * @Title: UserRoleService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 10:47
 */
public interface UserRoleService {
    /**
     * get all
     * @return
     */
    public List<UserRole> queryAllUserRoles();

    /**
     * get one by id
     * @param id
     * @return
     */
    public UserRole queryUserRoleById(Integer id);

    /**
     * update
     * @param role
     */
    public void updateUserRole(UserRole role);

    /**
     * delete role
     * @param id
     */
    public void deleteUserRole(Integer id);


    /**
     * 获取该user可授权的角色
     * @param userId
     * @return
     */
    public List<Role> getRole(Integer userId);

    /**
     * 给 user批量授权role
     * @param userId
     * @param roleIds
     */
    public void addRolesToUser(Integer userId,Integer[] roleIds);
}
