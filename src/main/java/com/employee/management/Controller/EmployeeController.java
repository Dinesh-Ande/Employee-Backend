package com.employee.management.Controller;

import com.employee.management.Model.Entity.Designation;
import com.employee.management.Model.Entity.Employee;
import com.employee.management.Exception.NoRecordFoundException;
import com.employee.management.Model.Request.EmployeeRequest;
import com.employee.management.Util.BackendListResponse;
import com.employee.management.Util.BackendResponse;
import com.employee.management.Model.Response.EmployeeResponse;
import com.employee.management.Util.ResponseUtil;
import com.employee.management.Service.DesignationService;
import com.employee.management.Service.EmployeeService;
import com.employee.management.Constants.EmployeeUrlConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(EmployeeUrlConstants.EMPLOYEE)
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    ResponseUtil responseUtil;
    @Autowired
    DesignationService designationService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BackendResponse<Employee> save(@RequestBody EmployeeRequest employeeRequest) throws NoRecordFoundException {
        Employee employee = employeeRequest.getEmployee();
        Designation designation = designationService.getDesignationById(employeeRequest.getDesignationId());
        employee.setDesignation(designation);
        employee = employeeService.createEmployee(employee);
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        return responseUtil.getBackendResponse(employeeResponse);
    }

    @GetMapping(EmployeeUrlConstants.EMPLOYEE_RETRIEVE)
    public BackendResponse<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        return responseUtil.getBackendResponse(employeeResponse);
    }

    @GetMapping
    public BackendListResponse getALLEmployeeByPagination(@RequestParam(value = "pageNo") Integer pageNo,
                                                          @RequestParam(value = "pageSize") Integer pageSize) {
        Integer count;
        count = employeeService.countAll();
        List<Employee> employeeList = employeeService.getAllEmployeeByPagination(pageNo, pageSize);
        return responseUtil.getBackendListResponse(employeeList, pageNo, pageSize, count);
    }

    @PutMapping(EmployeeUrlConstants.EMPLOYEE_UPDATE)
    public BackendResponse<Employee> updateEmployeeById(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id) {
        Employee employee = employeeRequest.getEmployee();
        employee = employeeService.updateEmployeeById(id, employee);
        EmployeeResponse employeeResponse = new EmployeeResponse(employee);
        return responseUtil.getBackendResponse(employeeResponse);
    }

    @DeleteMapping(EmployeeUrlConstants.EMPLOYEE_DELETE)
    public void deleteEmployeeById(@PathVariable Long id, Locale locale) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping(EmployeeUrlConstants.EMPLOYEE_RETRIEVE_ALL)
    public BackendResponse<Employee> getAllEmployee(){
        List<Employee> employeeList = employeeService.getAllEmployee();
        return responseUtil.getBackendResponse(employeeList);
    }
}
