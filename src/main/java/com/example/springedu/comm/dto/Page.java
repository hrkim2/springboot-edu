package com.example.springedu.comm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Page {
	@Setter
	private int page;
	@Setter
	private int pageSize;
	
	private int pageCount;
	@Setter
	private int total;
	@Setter
	private String sortBy;
	
	public void setPageCount() {
		//
	}
}
