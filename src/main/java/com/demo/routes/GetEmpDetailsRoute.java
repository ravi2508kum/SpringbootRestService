package com.demo.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class GetEmpDetailsRoute extends RouteBuilder{
	
	@Value("${rest.endpoint.path}")
	private String restpath;
	
	@Value("${employee.service.path}")
	private String empService;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from(restpath)		 
		  .routeId(getClass().getName())		  
		  .log("received request for empid: ${id}")
		  .log("calling employee service")
		  .toD(empService)
		  .log("received response from employee service");
		
	}

	

}
