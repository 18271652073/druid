package com.nbdeli.demo.dom.form;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/3/5.
 */
@lombok.Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "FPKJXX_XMXXS")
public class FPKJXX_XMXXS {
    private List<FPKJXX_XMXX> FPKJXX_XMXXS;
}
