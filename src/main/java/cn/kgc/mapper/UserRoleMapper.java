package cn.kgc.mapper;

import cn.kgc.po.Role;
import cn.kgc.po.UserRole;

import java.util.List;

/**
 * @author asus
 * @Title: UserRoleMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 15:04
 */
public interface UserRoleMapper {
    /**
     * get all
     * @return
     */
    public List<UserRole> getUserRoles();

    /**
     * get one by id
     * @param id
     * @return
     */
    public UserRole getUserRoleById(Integer id);

    /**
     * update
     * @param userRole
     */
    public void updateUserRole(UserRole userRole);

    /**
     * delete UserRole
     * @param id
     */
    public void deleteUserRole(Integer id);



    /**
     * 获取当前角色可授权的role
     * @param roleId
     * @return
     */
    public List<Role> getRole(List<Integer> roleId);

    /**
     * 获取该角色已授权的roleId
     * @param userId
     * @return
     */
    public List<Integer> getRoleId(Integer userId);

    /**
     * 给user授权Role
     * @param userRole
     */
    public void addRoleToUser(UserRole userRole);
}
