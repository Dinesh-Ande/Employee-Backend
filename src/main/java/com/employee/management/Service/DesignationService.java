package com.employee.management.Service;

import com.employee.management.Model.Entity.Designation;
import com.employee.management.Exception.NoRecordFoundException;

import java.util.List;

public interface DesignationService {
    Designation createDesignation(Designation designation);
    Designation getDesignationById(Long id) throws NoRecordFoundException;
    Designation updateDesignationById(Long id, Designation designation);
    void deleteDesignationById(Long id);
    List<Designation> getAllDesignation();
    List<Designation> getAllDesignationByPagination(Integer pageNo, Integer pageSize, String query);
    Integer countAll();
}
