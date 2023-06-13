package com.employee.management.Model.Request;

import com.employee.management.Model.Entity.Designation;

public class DesignationRequest {
    private String name;

    public Designation getDesignation(){
        Designation designation = new Designation();
        designation.setName(this.getName());
        return designation;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
