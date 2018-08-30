package cn.kgc.service.impl;

import cn.kgc.mapper.EmployeeMapper;
import cn.kgc.po.Department;
import cn.kgc.po.Employee;
import cn.kgc.service.intf.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: EmployeeServiceImpl
 * @ProjectName ssmcrud
 * @Description: TODO
 * @date 2018/8/7 16:56
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void delEmployee(int id) {
        employeeMapper.delEmployee(id);

    }

    @Override
    public List<Employee> queryAll() {
        List<Employee> employees = employeeMapper.queryAll();
        return employees;
    }

    @Override
    public List<Department> queryDepartment() {
        List<Department> departments = employeeMapper.queryDepartment();
        return departments;
    }

    @Override
    public Employee queryEmployeeById(Integer id) {
        Employee employee = employeeMapper.queryById(id);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public void delete(int id) {
        employeeMapper.delEmployee(id);
    }

}
