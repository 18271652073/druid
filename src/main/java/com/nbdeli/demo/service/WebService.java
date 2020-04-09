package com.nbdeli.demo.service;

import javax.jws.WebMethod;

/**
 * @author DuKaixiang
 * @date 2018/12/26.
 */
@javax.jws.WebService(serviceName = "WebService", targetNamespace = "http://www.baidu.com")
public interface WebService {
    //    @WebMethod(action = "sayHello")
//    String sayHello(String name);
    @WebMethod(action = "sayHello")
    String sayHello(String name, String passWord);
}
