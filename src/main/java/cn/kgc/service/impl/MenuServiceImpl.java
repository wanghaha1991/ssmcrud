package cn.kgc.service.impl;

import cn.kgc.mapper.MenuMapper;
import cn.kgc.po.Menu;
import cn.kgc.service.intf.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: MenuServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/10 11:40
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryAllMenus() {
       return menuMapper.getMenus();
    }

    @Override
    public Menu queryMenuById(Integer id) {
       return menuMapper.getMenuById(id);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);

    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteMenu(id);
    }

    @Override
    public void addMenu(Menu menu) {
        Integer level = menuMapper.getLevel(menu);
        menu.setLevel(level);
        menuMapper.addMenu(menu);
    }
}
