package com.employee.management.Util;

import org.springframework.stereotype.Component;

@Component
public class ResponseUtil {
    public BackendResponse getBackendResponse(Object data) {
        BackendResponse backendResponse = new BackendResponse<>();
        backendResponse.setData(data);
        return backendResponse;
    }

    public BackendListResponse getBackendListResponse(Object data, Integer pageNo, Integer pageSize, Integer count) {
        BackendListResponse backendListResponse = new BackendListResponse();
        backendListResponse.setData(data);
        backendListResponse.setPageNo(pageNo);
        backendListResponse.setPageSize(pageSize);
        backendListResponse.setCount(count);
        return backendListResponse;
    }
}
