package com.nbdeli.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages = {"com.nbdeli.demo.dom.user.mapper.**"})
public class DruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(DruidApplication.class, args);
	}

//	public static void main(String[] args) {
//		String address="http://localhost:8989/webservcie";
//		Endpoint.publish(address,new WebServiceImpl());
//		System.out.println("发布webservice！");
//		String url="http://localhost:8989/webservcie?wsdl";
//	}
}
