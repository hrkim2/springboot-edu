package com.example.springedu.comm.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class DataResponse<T> extends AppResponseCommon {
    private T result;

    public DataResponse(T result, HttpStatus status) {
		super(status, CommonResponse.getMsg(status));
		
        this.result = result;
    }

    public DataResponse(T result, HttpStatus status, String msg) {
		super(status, msg);
		
        this.result = result;
    }
}