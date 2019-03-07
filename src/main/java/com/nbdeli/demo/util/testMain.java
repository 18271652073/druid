package com.nbdeli.demo.util;

import com.nbdeli.demo.dom.Person;
import com.nbdeli.demo.dom.user.entity.User;

/**
 * @author Administrator
 * @date 2019/3/4.
 */
public class testMain {
    public static void main(String[] args) throws Exception{
        User user=new User();
        user.setPassword("231");
        user.setSalt("qerqwe");
        user.setUid(1);
        user.setUsername("wqe");
        Person person=new Person();
        person.setUser(user);
        person.setPassword("asdfasdf");
        person.setName("asfasdfsdfsa");
        String xmlstr=JaxbXmlUtil.convertToXml(person);
        System.out.println(xmlstr);
        Person entity=JaxbXmlUtil.convertToJavaBean(xmlstr,Person.class);
        System.out.println(entity);
    }
}
