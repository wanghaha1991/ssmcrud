package cn.kgc.controller;

import cn.kgc.po.Role;
import cn.kgc.po.User;
import cn.kgc.po.UserRole;
import cn.kgc.service.intf.UserRoleService;
import cn.kgc.service.intf.UserService;
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
 * @Title: UserRoleController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 15:27
 */
@Controller
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @RequestMapping("/userRoles")
    public String getAll(Model model) {
        List<UserRole> userRoles = userRoleService.queryAllUserRoles();
        model.addAttribute("userRoles", userRoles);
        return "userRole/list";
    }

    @RequestMapping("/userRole")
    public String add(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "userRole/add";
    }

    @RequestMapping(value = "/userRole", method = RequestMethod.POST)
    public String add(Integer userId, Integer[] roleIds) {
        userRoleService.addRolesToUser(userId,roleIds);
        return "redirect:/userRoles";
    }

    @RequestMapping(value = "/userRole/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        userRoleService.deleteUserRole(id);
        return "redirect:/userRoles";
    }

    /**
     * 获取user可授权的role
     * @param userId
     * @return
     */
    @RequestMapping(value = "/getRole", method = RequestMethod.POST)
    public @ResponseBody
    List<Role> getRole(int userId) {
        List<Role> roles = userRoleService.getRole(userId);
        return roles;
    }

}
