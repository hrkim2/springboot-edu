package com.example.springedu.edu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.springedu.comm.dto.CommonResponse;
import com.example.springedu.edu.dto.SomeRequest;
import com.example.springedu.edu.model.Input1;
import com.example.springedu.edu.model.Input3;

@Controller
@RequestMapping("/some-request")
@Slf4j
public class SomeRequestController {

	@RequestMapping("")
	public String someRequest(Model model) {
		model.addAttribute("input1", Input1.values());
		
		return "hr/home";
	}
	
	@GetMapping("/input3")
	public CommonResponse getInput3List(@RequestParam String input2) {
		
		if(input2==null || input2.equals("")) {
			return new CommonResponse(null, HttpStatus.BAD_REQUEST, "invalid request.");
		}else {
			CommonResponse res = new CommonResponse(Input3.values(), "get data!");
			return res;
		}
	}
	
	@PostMapping("")
	public CommonResponse postTest(@RequestBody SomeRequest requestObj) {
		String value1, value2, value3;
		log.info("input 1 : "+(value1=requestObj.getInput1()));
		log.info("input 2 : "+(value2=requestObj.getInput2()));
		log.info("input 3 : "+(value3=requestObj.getInput3()));
		
		if((value1==null || value1.equals("")) || (value2==null || value2.equals(""))
				|| (value3==null || value3.equals(""))) {
			return new CommonResponse(null, HttpStatus.BAD_REQUEST, "invalid request.");
		}else {
			return new CommonResponse(null, "POST success!");
		}
	}
	
	@RequestMapping("/items")
	public String someItems(Model model) {
		model.addAttribute("input1", Input1.values());
		model.addAttribute("input3", Input3.values());
		
		return "hr/list";
	}
	
	@GetMapping("/items/list")
	public CommonResponse getList(@RequestParam SomeRequest requestObj) {
		return new CommonResponse(null, "POST success!");
	}
}
