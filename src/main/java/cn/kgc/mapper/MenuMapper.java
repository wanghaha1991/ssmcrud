package cn.kgc.mapper;

import cn.kgc.po.Menu;

import java.util.List;

/**
 * @author asus
 * @Title: MenuMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 11:26
 */
public interface MenuMapper {
    /**
     * get all
     * @return
     */
    public List<Menu> getMenus();

    /**
     * get one by id
     * @param id
     * @return
     */
    public Menu getMenuById(Integer id);

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

    /**
     * 级别
     * @param menu
     * @return
     */
    public Integer getLevel(Menu menu);
}
