package com.fxsimulator.usermanagementservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
//@AllArgsConstructor
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private List<T> dt;
    private Object metadata;

    public ApiResponse(String status, String message, T data, Object metadata) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.metadata = metadata;
    }

    public ApiResponse(String status, String message,  List<T> dt, Object metadata) {
        this.status = status;
        this.message = message;
        this.metadata = metadata;
        this.dt = dt;
    }
}
