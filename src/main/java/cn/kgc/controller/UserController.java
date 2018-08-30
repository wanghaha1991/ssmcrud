package cn.kgc.controller;

import cn.kgc.po.User;
import cn.kgc.service.intf.UserService;
import cn.kgc.vo.Node;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author asus
 * @Title: UserController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 9:50
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录校验
     * @param user
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        //基于subject的操作
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        token.setRememberMe(true);
        try {
            if (!subject.isAuthenticated()) {
                //登录
                subject.login(token);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "redirect:/main";
    }

    /**
     * 左侧菜单
     *
     * @return
     */
    @RequestMapping(value = "/getTree")
    public @ResponseBody
    List<Node> getTree(String username) {
        List<Node> nodes = userService.getNodes(username);
        return nodes;
    }

    /**
     * 主列表
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/users")
    public String getUsers(Map map) {
        List<User> users = userService.getUsers();
        map.put("users", users);
        return "user/list";
    }

    /**
     * add
     *
     * @return
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String add() {
        return "user/add";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String add(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    /**
     * 修改
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        User user = userService.queryUserById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable int id, User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/users";
    }


    @RequestMapping(value = "/isExist", method = RequestMethod.POST)
    public @ResponseBody Integer isExist(String username) {
        Integer exist = userService.isExist(username);
        return exist;
    }

}
