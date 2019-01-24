package com.nbdeli.demo.dom.usertest.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * user
 * @author 
 */
@Entity
@Table(name = "user")
@Data
public class UserDo implements Serializable {
    @Id
    private Integer uid;
    @Column(length = 32)
    private String username;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String salt;

    private static final long serialVersionUID = 1L;

}