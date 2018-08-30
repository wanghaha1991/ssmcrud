package cn.kgc.mapper;

import cn.kgc.po.Department;
import cn.kgc.po.Employee;

import java.util.List;

/**
 * @author asus
 * @Title: EmployeeMapper
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/7 16:52
 */
public interface EmployeeMapper {
    /**
     * 添加操作
     * @param employee
     */
    public void addEmployee(Employee employee);

    /**
     * 删除employee
     * @param id
     */
    public void delEmployee(Integer id);

    /**
     * 查询所有employee
     * @return
     */
    public List<Employee> queryAll();

    /**
     * 查询部门
     * @return
     */
    public List<Department> queryDepartment();

    /**
     * 查询单个员工
     * @param id
     * @return
     */
    public Employee queryById(Integer id);

    /**
     * 修改
     * @param employee
     */
    public void updateEmployee(Employee employee);

}
