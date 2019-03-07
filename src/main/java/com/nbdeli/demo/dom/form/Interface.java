package com.nbdeli.demo.dom.form;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 * @date 2019/3/5.
 */
@lombok.Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "interface")
public class Interface {
    private GlobalInfo globalInfo;
    private Data Data;
}
