package com.employee.management.Model.Response;

import com.employee.management.Model.Entity.Designation;

public class DesignationResponse {
    private Long id;
    private String name;

    public DesignationResponse(Designation designation) {
        this.id = designation.getId();
        this.name = designation.getName();
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

}
