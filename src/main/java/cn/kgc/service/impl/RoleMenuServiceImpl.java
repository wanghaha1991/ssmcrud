package cn.kgc.service.impl;

import cn.kgc.mapper.RoleMenuMapper;
import cn.kgc.po.Menu;
import cn.kgc.po.Role;
import cn.kgc.po.RoleMenu;
import cn.kgc.service.intf.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: RoleMenuServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 16:14
 */

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> queryAllRoleMenus() {
        return roleMenuMapper.getRoleMenus();
    }

    @Override
    public RoleMenu queryRoleMenuById(Integer id) {
        return roleMenuMapper.getRoleMenuById(id);
    }

    @Override
    public void updateRoleMenu(RoleMenu roleMenu) {

    }

    @Override
    public void deleteRoleMenu(Integer id) {
        roleMenuMapper.deleteRoleMenu(id);
    }

    /**
     * 批量添加
     * @param roleId
     * @param menuIds
     */
    @Override
    public void addRoleMenu(Integer roleId, Integer[] menuIds) {
        RoleMenu roleMenu = new RoleMenu();
        Role role = new Role();
        Menu menu = new Menu();
        roleMenu.setMenu(menu);
        roleMenu.setRole(role);
        for (int i = 0;i<menuIds.length;i++){
            roleMenu.getMenu().setId(menuIds[i]);
            roleMenu.getRole().setId(roleId);
            roleMenuMapper.addRoleMenu(roleMenu);
        }
    }

    @Override
    public List<Menu> getMenus(Integer roleId) {
        List<Integer> menuIds = roleMenuMapper.getMenusByRoleId(roleId);
        //如果该橘色没有授权,会出现NOT IN的异常，添加一个-1
        menuIds.add(-1);
        List<Menu> menus = roleMenuMapper.getMenus(menuIds);
        return menus;
    }
}
