package com.nbdeli.demo.service;

import javax.xml.ws.Endpoint;

/**
 * @author DuKaixiang
 * @date 2018/12/26.
 */
public class WebServicePublish {
    public static void main(String[] args) {
        String address = "http://localhost:8989/webservcie";
        Endpoint.publish(address, new WebServiceImpl());
        System.out.println("发布webservice！");
    }
}
