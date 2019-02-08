package com.project.springsecurity.plotlyjs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
    public String showHome() {
        return "home";
    }
	
	//add request mapping for leaders
	@GetMapping("/machine")
    public String showMachine() {  
        return "MachineLearning";
    }
	
	//add request mapping for systems
	@GetMapping("/pong")
	public String showPong() {	        
	     return "systems";
	 }
	
}
