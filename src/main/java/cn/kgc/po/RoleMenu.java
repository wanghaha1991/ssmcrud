package cn.kgc.po;

/**
 * @author asus
 * @Title: RoleMenu
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 16:08
 */
public class RoleMenu {
    private int id;
    private Role role;
    private Menu menu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
