package com.nbdeli.demo.service;

import javax.jws.WebMethod;

/**
 * @author DuKaixiang
 * @date 2018/12/26.
 */
@javax.jws.WebService
public interface WebService {
    @WebMethod
    String sayHello(String name,String passWord);
}
