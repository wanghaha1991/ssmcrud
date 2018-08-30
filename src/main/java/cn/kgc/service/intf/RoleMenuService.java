package cn.kgc.service.intf;

import cn.kgc.po.Menu;
import cn.kgc.po.Role;
import cn.kgc.po.RoleMenu;

import java.util.List;

/**
 * @author asus
 * @Title: RoleMenuService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 16:13
 */
public interface RoleMenuService {
    /**
     * get all
     * @return
     */
    public List<RoleMenu> queryAllRoleMenus();

    /**
     * get one by id
     * @param id
     * @return
     */
    public RoleMenu queryRoleMenuById(Integer id);

    /**
     * update
     * @param roleMenu
     */
    public void updateRoleMenu(RoleMenu roleMenu);

    /**
     * delete role
     * @param id
     */
    public void deleteRoleMenu(Integer id);

    /**
     * add role
     * @param roleId
     * @param menuIds
     */
    public void addRoleMenu(Integer roleId,Integer[] menuIds);

    /**
     * 获取该role可授权的菜单
     * @param roleId
     * @return
     */
    public List<Menu> getMenus(Integer roleId);
    
}
