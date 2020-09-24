package com.zabir.springboot.cms.contollers;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController; 

@RestController  
public class HelloWorldController {
	@RequestMapping("/") //map to the default starter 
	public String hello()   
	{  
		return "Hello World";  
	}  
	
}
