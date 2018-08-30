package cn.kgc.mapper;

import cn.kgc.po.Menu;
import cn.kgc.po.RoleMenu;

import java.util.List;

/**
 * @author asus
 * @Title: RoleMenuMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 16:10
 */
public interface RoleMenuMapper {
    /**
     * get all
     * @return
     */
    public List<RoleMenu> getRoleMenus();

    /**
     * get one by id
     * @param id
     * @return
     */
    public RoleMenu getRoleMenuById(Integer id);

    /**
     * update
     * @param roleMenu
     */
    public void updateRoleMenu(RoleMenu roleMenu);

    /**
     * delete RoleMenu
     * @param id
     */
    public void deleteRoleMenu(Integer id);

    /**
     * add RoleMenu
     * @param roleMenu
     */
    public void addRoleMenu(RoleMenu roleMenu);

    /**
     * 获取该角色已授权的菜单编号
     * @param roleId
     * @return
     */
    public List<Integer> getMenusByRoleId(Integer roleId);

    /**
     * 获取该角色可授权的菜单
     * @param menus
     * @return
     */
    public List<Menu> getMenus(List<Integer> menus);
}
