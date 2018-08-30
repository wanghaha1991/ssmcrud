package cn.kgc.service.intf;

import cn.kgc.po.Department;
import cn.kgc.po.Employee;

import java.util.List;

/**
 * @author asus
 * @Title: EmployeeService
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/7 16:46
 */
public interface EmployeeService {
    /**
     * 添加操作
     *
     * @param employee
     */
    public void addEmployee(Employee employee);

    /**
     * 删除
     *
     * @param id
     */
    public void delEmployee(int id);

    /**
     * 查询所有
     * @return
     */
    public List<Employee> queryAll();

    /**
     * 查询所有表情
     * @return
     */
    public List<Department> queryDepartment();

    /**
     * 查询单个员工信息
     * @param id
     * @return
     */
    public Employee queryEmployeeById(Integer id);

    /**
     * 修改信息
     * @param employee
     */
    public void update(Employee employee);

    /**
     * 删除
     * @param id
     */
    public void delete(int id);
}
