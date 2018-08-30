package cn.kgc.controller;

import cn.kgc.po.Department;
import cn.kgc.po.Employee;
import cn.kgc.service.impl.EmployeeServiceImpl;
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
 * @Title: EmployeeController
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/7 16:44
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 显示所有员工信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/emps")
    public String queryAll(Map map) {
        List<Employee> employees = this.employeeService.queryAll();
        map.put("emps", employees);
        return "emp/list";
    }

    /**
     * 跳转到添加页面
     * @param map
     * @return
     */

    @RequestMapping(value = "/emp")
    public String add(Map map) {
        List<Department> departments = employeeService.queryDepartment();
        map.put("depts", departments);
        return "emp/add";
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String add(Employee employee) {
        this.employeeService.addEmployee(employee);
        return "redirect:/emps";
    }

    /**
     * 修改页面
     * @param id
     * @param model
     * @return
     */

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model) {
        Employee employee = employeeService.queryEmployeeById(id);
        List<Department> departments = employeeService.queryDepartment();
        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);
        return "emp/update";
    }

    /**
     * 修改
     * @param employee
     * @return
     */

    @RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/emps";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }
}
