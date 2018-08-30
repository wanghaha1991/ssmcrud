package cn.kgc.mapper;


import cn.kgc.po.Role;

import java.util.List;

/**
 * @author asus
 * @Title: RoleMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 10:37
 */
public interface RoleMapper {
    /**
     * get all
     * @return
     */
    public List<Role> getRoles();

    /**
     * get one by id
     * @param id
     * @return
     */
    public Role getRoleById(Integer id);

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
