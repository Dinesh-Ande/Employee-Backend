package com.employee.management.Util;

import com.fasterxml.jackson.annotation.JsonInclude;

public class BackendResponse<T> {
    private T data;

    public BackendResponse() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BackendResponse{" +
                "data=" + data +
                '}';
    }
}
