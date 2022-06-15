package com.example.springedu.comm.dto;

import java.util.List;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ListResponse<T> extends AppResponseCommon {
	private List<T> result;
	private Page page;

	public ListResponse(List<T> result, Page page, HttpStatus status) {
		super(status, CommonResponse.getMsg(status));
		
        this.result = result;
        setPage(page);
	}

    public ListResponse(List<T> result, Page page, HttpStatus status, String msg) {
		super(status, msg);
		
        this.result = result;
        setPage(page);
    }
	
	private void setPage(Page page) {
		page.setPageCount();
		this.page = page;
	}
}
