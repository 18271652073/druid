package com.nbdeli.demo.dom.form;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 * @date 2019/3/4.
 */

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "globalInfo")
public class GlobalInfo {
    private String version;
    private String interfaceCode;
    private String token;
    private String requestTime;
}
