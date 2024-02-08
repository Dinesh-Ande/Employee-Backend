package com.employee.management.Controller;

import com.employee.management.Model.Entity.Designation;
import com.employee.management.Exception.NoRecordFoundException;
import com.employee.management.Util.BackendListResponse;
import com.employee.management.Util.BackendResponse;
import com.employee.management.Util.ResponseUtil;
import com.employee.management.Constants.DesignationUrlConstants;
import com.employee.management.Model.Request.DesignationRequest;
import com.employee.management.Model.Response.DesignationResponse;
import com.employee.management.Service.DesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DesignationUrlConstants.DESIGNATION)
public class DesignationController {
    @Autowired
    DesignationService designationService;
    @Autowired
    ResponseUtil responseUtil;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BackendResponse<Designation> createDesignation(@RequestBody DesignationRequest designationRequest) {
        Designation designation = designationRequest.getDesignation();
        designation = designationService.createDesignation(designation);
        DesignationResponse designationResponse = new DesignationResponse(designation);
        return responseUtil.getBackendResponse(designationResponse);
    }

    @GetMapping(DesignationUrlConstants.DESIGNATION_RETRIEVE)
    public BackendResponse<Designation> getDesignationById(@PathVariable Long id) throws NoRecordFoundException {
        Designation designation = designationService.getDesignationById(id);
        DesignationResponse designationResponse = new DesignationResponse(designation);
        return responseUtil.getBackendResponse(designationResponse);
    }

    @GetMapping
    public BackendListResponse getAllByPagination(@RequestParam(value = "pageNo") Integer pageNo,
                                                  @RequestParam(value = "pageSize") Integer pageSize) {
        Integer count;
        count = designationService.countAll();
        List<Designation> designationList = designationService.getAllDesignationByPagination(pageNo, pageSize);
        return responseUtil.getBackendListResponse(designationList, pageNo, pageSize, count);
    }

    @PutMapping(DesignationUrlConstants.DESIGNATION_UPDATE)
    public BackendResponse<Designation> updateDesignationById(@PathVariable Long id, @RequestBody DesignationRequest designationRequest) {
        Designation designation = designationRequest.getDesignation();
        designation = designationService.updateDesignationById(id, designation);
        DesignationResponse designationResponse = new DesignationResponse(designation);
        return responseUtil.getBackendResponse(designationResponse);
    }

    @DeleteMapping(DesignationUrlConstants.DESIGNATION_DELETE)
    public void deleteDesignationById(@PathVariable Long id) {
        designationService.deleteDesignationById(id);
    }

    @GetMapping(DesignationUrlConstants.DESIGNATION_RETRIEVE_ALL)
    public BackendResponse<Designation> getAllDesignation() {
        List<Designation> designationList = designationService.getAllDesignation();
        return responseUtil.getBackendResponse(designationList);
    }
}
