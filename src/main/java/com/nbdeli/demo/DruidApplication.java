package com.nbdeli.demo;

import com.nbdeli.demo.service.WebServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.ws.Endpoint;

@SpringBootApplication
@MapperScan(basePackages = {"com.nbdeli.demo.dom.*.mapper.**"})
public class DruidApplication {

	public static void main(String[] args) {
		SpringApplication.run(DruidApplication.class, args);
	}

//    public static void main(String[] args) {
//        String address = "http://localhost:8989/udesk/webservcie";
//        Endpoint.publish(address, new WebServiceImpl());
//        System.out.println("发布webservice！");
//        String url = "http://localhost:8989/udesk/webservcie?wsdl";
//    }
}
