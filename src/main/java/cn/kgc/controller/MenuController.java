package cn.kgc.controller;

import cn.kgc.po.Menu;
import cn.kgc.service.intf.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * @Title: MenuController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 11:42
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/menus")
    public String list(Model model) {
        List<Menu> menus = menuService.queryAllMenus();
        model.addAttribute("menus", menus);
        return "menu/list";
    }

    @RequiresPermissions("menu_manage")
    @RequestMapping("/menu")
    public String add(Model model) {
        //拿到所有的菜单
        List<Menu> menus = menuService.queryAllMenus();
        model.addAttribute("menus",menus);
        return "menu/add";
    }

    @RequiresPermissions("menu_manage")
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String add(Menu menu) {
        menuService.addMenu(menu);
        return "redirect:/menus";
    }

    @RequiresPermissions("menu_manage")
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Menu menu = menuService.queryMenuById(id);
        model.addAttribute("menu", menu);
        return "menu/update";
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable int id, Menu menu) {
        menuService.updateMenu(menu);
        return "redirect:/menus";
    }

    @RequiresPermissions("menu_manage")
    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        menuService.deleteMenu(id);
        return "redirect:/menus";
    }
}
