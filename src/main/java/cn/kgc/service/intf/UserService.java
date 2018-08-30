package cn.kgc.service.intf;

import cn.kgc.vo.Node;
import cn.kgc.po.User;

import java.util.List;

/**
 * @author asus
 * @Title: UserService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/9 9:40
 */
public interface UserService {
    /**
     * 校验重复
     *
     * @param username
     * @return
     */
    public Integer isExist(String username);

    /**
     * 获取节点树
     * @param name
     * @return
     */
    public List<Node> getNodes(String name);

    /**
     * 查询所有的user
     * @return
     */
    public List<User> getUsers();

    /**
     * 增加user
     * @param user
     */
    public void addUser(User user);

    /**
     * 查询
     * @param id
     * @return
     */
    public User queryUserById(Integer id);

    /**
     * 修改
     * @param user
     */
    public void updateUser(User user);

    /**
     * 删除
     * @param id
     */
    public void delete(Integer id);


}
