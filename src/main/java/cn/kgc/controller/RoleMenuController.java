package cn.kgc.controller;

import cn.kgc.po.*;
import cn.kgc.service.intf.MenuService;
import cn.kgc.service.intf.RoleMenuService;
import cn.kgc.service.intf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author asus
 * @Title: UserMenuController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 16:16
 */
@Controller
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    @RequestMapping("/roleMenus")
    public String list(Model model) {
        List<RoleMenu> roleMenus = roleMenuService.queryAllRoleMenus();
        model.addAttribute("roleMenus", roleMenus);
        return "roleMenu/list";
    }
    @RequestMapping("/roleMenu")
    public String add(Model model){
        List<Menu> menus = menuService.queryAllMenus();
        List<Role> roles = roleService.queryAllRoles();
        model.addAttribute("menus",menus);
        model.addAttribute("roles",roles);
        return "roleMenu/add";
    }
    @RequestMapping(value = "/roleMenu",method = RequestMethod.POST)
    public String add(Integer roleId,Integer[] menuIds){
        roleMenuService.addRoleMenu(roleId,menuIds);
        return "redirect:/roleMenus";
    }
    @RequestMapping(value = "/roleMenu/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        roleMenuService.deleteRoleMenu(id);
        return "redirect:/roleMenus";
    }
    @RequestMapping(value = "/getMenu", method = RequestMethod.POST)
    public @ResponseBody
    List<Menu> getRole(int roleId) {
        List<Menu> menus = roleMenuService.getMenus(roleId);
        return menus;
    }
}
