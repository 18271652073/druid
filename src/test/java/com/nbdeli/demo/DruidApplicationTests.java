package com.nbdeli.demo;

import com.nbdeli.demo.service.SystemConstantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidApplicationTests {

	@Autowired
	private SystemConstantService systemConstantService;
	@Test
	public void contextLoads() throws IOException {
		System.out.println(systemConstantService.insertEntity()==1?"导入成功！":"失败！");
	}
	@Test
	public void contextLoads1() throws IOException {
		System.out.println(systemConstantService.selectBlob(1));
	}

}
