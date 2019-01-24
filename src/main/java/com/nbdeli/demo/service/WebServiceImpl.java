package com.nbdeli.demo.service;

/**
 * @author DuKaixiang
 * @date 2018/12/26.
 */
@javax.jws.WebService
public class WebServiceImpl implements WebService {
    @Override
    public String sayHello(String name,String passWord) {
        System.out.println("hihihi");
        return name+":"+passWord;
    }
}
