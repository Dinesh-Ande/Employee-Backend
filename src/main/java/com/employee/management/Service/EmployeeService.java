package com.employee.management.Service;

import com.employee.management.Model.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployeeById(Long id, Employee employee);
    void deleteEmployeeById(Long id);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByPagination(Integer pageNo, Integer pageSize);
    Integer countAll();
}
