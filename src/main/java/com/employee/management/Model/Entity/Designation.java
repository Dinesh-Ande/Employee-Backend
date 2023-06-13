package com.employee.management.Model.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Designation_Details",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
        }
)
public class Designation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

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
