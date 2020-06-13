package com.cimb.tokolapak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello")
	public String helloWorld() {
		return ("helloooooooooo");
	}
	
	@GetMapping("/hello{name}")
	public String helloNme(@PathVariable() String name) {
		return "hello" + name;
	}
}
