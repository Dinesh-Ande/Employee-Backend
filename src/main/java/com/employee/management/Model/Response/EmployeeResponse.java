package com.employee.management.Model.Response;

import com.employee.management.Model.Entity.Designation;
import com.employee.management.Model.Entity.Employee;

public class EmployeeResponse {
    private Long id;
    private  String name;
    private String eMail;
    private  Long phoneNo;
    private String dateOfJoining;
    private Designation designation;

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.eMail = employee.geteMail();
        this.phoneNo = employee.getPhoneNo();
        this.dateOfJoining = employee.getDateOfJoining();
        this.designation = employee.getDesignation();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}
