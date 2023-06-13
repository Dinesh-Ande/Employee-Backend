package com.employee.management.Model.Request;

import com.employee.management.Model.Entity.Employee;

public class EmployeeRequest {
    private  String name;
    private String eMail;
    private  Long phoneNo;
    private String dateOfJoining;
    private Long designationId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }
    public Employee getEmployee(){
        Employee employee = new Employee();
        employee.setPhoneNo(this.getPhoneNo());
        employee.setName(this.getName());
        employee.setDateOfJoining(this.getDateOfJoining());
        employee.seteMail(this.geteMail());
        return employee;
    }
}
