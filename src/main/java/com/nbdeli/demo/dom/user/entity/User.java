package com.nbdeli.demo.dom.user.entity;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * user
 * @author 
 */
//@XmlAccessorType (XmlAccessType.FIELD)
//@XmlAccessorType (XmlAccessType.PROPERTY)
@XmlRootElement(name = "user")
public class User implements Serializable {
    private Integer uid;

    private String username;

    private String password;

    private String salt;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}