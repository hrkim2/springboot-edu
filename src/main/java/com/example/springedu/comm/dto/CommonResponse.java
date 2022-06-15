package com.example.springedu.comm.dto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Getter;

@Getter
public class CommonResponse<T> extends ResponseEntity {
	public CommonResponse(T result, String msg){
        this(new DataResponse(result, HttpStatus.OK, msg));
    }

    public CommonResponse(T result){
        this(new DataResponse(result, HttpStatus.OK));
    }

    public CommonResponse(T result, HttpStatus status, String msg){
        this(new DataResponse(result, status, msg));
    }

    private CommonResponse(DataResponse body) {
        super(body, body.getStatus());
    }
    
    
	public CommonResponse(List<T> result, Page page, String msg){
        this(new ListResponse(result, page, HttpStatus.OK, msg));
    }

    public CommonResponse(List<T> result, Page page){
        this(new ListResponse(result, page, HttpStatus.OK));
    }

    public CommonResponse(List<T> result, Page page, HttpStatus status, String msg){
        this(new ListResponse(result, page, status, msg));
    }

    private CommonResponse(ListResponse body) {
        super(body, body.getStatus());
    }

    public static String getMsg(HttpStatus status){
        String message;

        switch (status){
            case OK:
                message = "success";
                break;
            case NOT_FOUND:
                message = "can not found data";
                break;
            default:
                message = "";
        }

        return message;
    }
}
