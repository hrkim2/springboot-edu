package com.example.springedu.comm.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public abstract class AppResponseCommon {
	private HttpStatus status;
	private String msg;
	
	public AppResponseCommon(HttpStatus status, String msg) {
		this.status = status;
		this.msg = msg;
	}
}
