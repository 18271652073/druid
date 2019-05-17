package com.nbdeli.demo.service;

import javax.jws.WebParam;

/**
 * @author DuKaixiang
 * @date 2018/12/26.
 */
@javax.jws.WebService
public class WebServiceImpl implements WebService {
//    @Override
//    public String sayHello(String xml) {
//        System.out.println("hihihi");
//        return xml;
//    }
    @Override
    public String sayHello(@WebParam(name = "name") String name,@WebParam(name = "passWord") String passWord) {
        System.out.println("hihihi:"+name+":"+passWord);
        return name+":"+passWord;
    }
}
