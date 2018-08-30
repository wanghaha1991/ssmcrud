package cn.kgc.service.intf;

import cn.kgc.po.Menu;

import java.util.List;

/**
 * @author asus
 * @Title: MenuService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 11:38
 */
public interface MenuService {
    /**
     * get all
     * @return
     */
    public List<Menu> queryAllMenus();

    /**
     * get one by id
     * @param id
     * @return
     */
    public Menu queryMenuById(Integer id);

    /**
     * update
     * @param menu
     */
    public void updateMenu(Menu menu);

    /**
     * delete Menu
     * @param id
     */
    public void deleteMenu(Integer id);

    /**
     * add Menu
     * @param menu
     */
    public void addMenu(Menu menu);
}
