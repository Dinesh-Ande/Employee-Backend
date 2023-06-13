package com.employee.management.Service.Impl;

import com.employee.management.Model.Entity.Designation;
import com.employee.management.Exception.NoRecordFoundException;
import com.employee.management.Repository.DesignationRepository;
import com.employee.management.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DesignationServiceImpl implements DesignationService {
    @Autowired
    DesignationRepository designationRepository;
    @Override
    public Designation createDesignation(Designation designation) {
        Designation designationDB = designationRepository.save(designation);
        return designationDB;
    }

    @Override
    public Designation getDesignationById(Long id) throws NoRecordFoundException {
        Designation designationDB = designationRepository.findDesignationById(id);
        if (designationDB == null){
            List<Object> objects = new ArrayList<>();
            objects.add(id);
            throw new NoRecordFoundException(objects);
        }
        return designationDB;
    }

    @Override
    public Designation updateDesignationById(Long id, Designation designation) {
        Designation designationDB = designationRepository.findDesignationById(id);
        designationDB.setName(designation.getName());
        designationDB = designationRepository.save(designationDB);
        return designationDB;
    }

    @Override
    public void deleteDesignationById(Long id) {
        Designation designationDB = designationRepository.findDesignationById(id);
        designationRepository.delete(designationDB);
    }

    @Override
    public List<Designation> getAllDesignation() {
        List<Designation> designationList = designationRepository.findAll();
        return designationList;
    }

    @Override
    public List<Designation> getAllDesignationByPagination(Integer pageNo, Integer pageSize, String query) {
        List<Designation> designationList = new ArrayList<>();
        Pageable pageable =  PageRequest.of(pageNo - 1,pageSize);
        if (query == null)
            designationRepository.findAll(pageable).forEach(designationList::add);
        else
            designationRepository.findAllDesignationByQuery(query,pageable);
        return designationList;
    }

    @Override
    public Integer countAll() {
        return designationRepository.countAll();
    }
}
