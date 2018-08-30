package cn.kgc.po;

/**
 * @author asus
 * @Title: UserRole
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 15:01
 */
public class UserRole {
    private int id;
    private User user;
    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
