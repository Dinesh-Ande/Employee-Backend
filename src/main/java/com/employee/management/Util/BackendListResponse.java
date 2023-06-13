package com.employee.management.Util;

public class BackendListResponse extends BackendResponse {
    private Integer pageNo;
    private Integer pageSize;
    private Integer count;

    public BackendListResponse() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "BackendListResponse{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", count=" + count +
                '}';
    }
}
