package cn.kgc.mapper;

import cn.kgc.vo.Node;
import cn.kgc.po.User;

import java.util.List;
import java.util.Set;

/**
 * @author asus
 * @Title: UserMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 9:43
 */
public interface UserMapper {
    /**
     * 登录校验
     * @param user
     * @return
     */
    public Integer login(User user);

    /**
     * 拿到所有的节点
     * @param name
     * @return
     */
    public List<Node> getNodes(String name);

    /**
     * 拿到所有的user
     * @return
     */
    public List<User> getUsers();

    /**
     * 增加user
     * @param user
     * @return
     */
    public void addUser(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 修改
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除
     * @param id
     */
    public void deleteUser(Integer id);

    /**
     * get User BY name
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 得到数量
     * @param username
     * @return
     */
    public Integer getNumByName(String username);

    /**
     * 获取当前用户的所有权限
     * @param user
     * @return
     */
    public List<String> getAllPrivilege(User user);

    /**
     * 拿到所有的节点
     * @return
     */
    public List<Node> getAllNodes();

}
