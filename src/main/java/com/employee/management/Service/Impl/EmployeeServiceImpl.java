package com.employee.management.Service.Impl;

import com.employee.management.Model.Entity.Employee;
import com.employee.management.Repository.EmployeeRepository;
import com.employee.management.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeDB = employeeRepository.save(employee);
        return employeeDB;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employeeDB = employeeRepository.findEmployeeById(id);
        return employeeDB;
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Employee employeeDB = employeeRepository.findEmployeeById(id);
        employeeDB.setName(employee.getName());
        employeeDB.seteMail(employee.geteMail());
        employeeDB.setPhoneNo(employee.getPhoneNo());
        employeeDB.setDateOfJoining(employee.getDateOfJoining());
        employeeDB = employeeRepository.save(employeeDB);
        return employeeDB;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        Employee employeeDB = employeeRepository.findEmployeeById(id);
        employeeRepository.delete(employeeDB);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployeeByPagination(Integer pageNo, Integer pageSize, String query) {
        List<Employee> employeeList = new ArrayList<>();
        Pageable pageable =  PageRequest.of(pageNo - 1,pageSize);
        if (query == null)
            employeeRepository.findAll(pageable).forEach(employeeList::add);
        else
            employeeRepository.findAllDesignationByQuery(query,pageable);
        return employeeList;
    }

    @Override
    public Integer countAll() {
        return employeeRepository.countAll();
    }
}
