package com.nbdeli.demo.dom;

import com.nbdeli.demo.dom.user.entity.User;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 * @date 2019/3/4.
 */
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorType (XmlAccessType.PROPERTY)
@XmlRootElement(name = "person")
public class Person {
    private User user;
    private String name;
    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "user=" + user +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
