package com.nbdeli.demo.dom.form;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 * @date 2019/3/4.
 */
@lombok.Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "REQUEST_FPKJXX")
public class REQUEST_FPKJXX {
    private FPKJXX_FPTXX FPKJXX_FPTXX;
    private FPKJXX_XMXXS FPKJXX_XMXXS;
}
