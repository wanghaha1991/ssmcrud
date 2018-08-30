package cn.kgc.service.impl;

import cn.kgc.mapper.UserMapper;
import cn.kgc.po.User;
import cn.kgc.service.intf.UserService;
import cn.kgc.utils.Cryptography;
import cn.kgc.utils.NodeUtil;
import cn.kgc.vo.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author asus
 * @Title: UserServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 9:42
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Node> getNodes(String name) {
        //当前用户拥有的权限节点
        List<Node> nodes = userMapper.getNodes(name);
        //拿到所有节点，防止数据库的多次IO
        List<Node> allNodes = userMapper.getAllNodes();

        List<Node> list = NodeUtil.logicNode(nodes, allNodes);

        List<Node> nodeList = NodeUtil.sort(list);

        return nodeList;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        return users;
    }

    @Override
    public void addUser(User user) {
        //加密
        User user1 = Cryptography.md5(user);
        userMapper.addUser(user1);
    }

    @Override
    public User queryUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
        User user1 = Cryptography.md5(user);
        userMapper.updateUser(user1);
    }

    @Override
    public void delete(Integer id) {
        userMapper.deleteUser(id);
    }

    @Override
    public Integer isExist(String username) {
        Integer flag = userMapper.getNumByName(username);
        return flag;
    }
}
