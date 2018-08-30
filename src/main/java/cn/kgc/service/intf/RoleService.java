package cn.kgc.service.intf;

import cn.kgc.po.Role;

import java.util.List;

/**
 * @author asus
 * @Title: RoleService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 10:47
 */
public interface RoleService {
    /**
     * get all
     * @return
     */
    public List<Role> queryAllRoles();

    /**
     * get one by id
     * @param id
     * @return
     */
    public Role queryRoleById(Integer id);

    /**
     * update
     * @param role
     */
    public void updateRole(Role role);

    /**
     * delete role
     * @param id
     */
    public void deleteRole(Integer id);

    /**
     * add role
     * @param role
     */
    public void addRole(Role role);
}
