package cn.kgc.controller;

import cn.kgc.po.Role;
import cn.kgc.service.intf.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @Title: RoleController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 10:37
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/roles")
    public String list(Map map){
        List<Role> roles = roleService.queryAllRoles();
        map.put("roles",roles);
        return "role/list";
    }

    /**
     * add
     * @return
     */
    @RequestMapping(value = "/role",method = RequestMethod.GET)
    public String add(){
        return "role/add";
    }
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public String add(Role role){
        roleService.addRole(role);
        return "redirect:/roles";
    }

    /**
     * update
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model){
        Role role = roleService.queryRoleById(id);
        model.addAttribute("role",role);
        return "role/update";
    }
    @RequestMapping(value = "/role/{id}",method = RequestMethod.PUT)
    public String update(Role role){
        roleService.updateRole(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        roleService.deleteRole(id);
        return "redirect:/roles";
    }



}
