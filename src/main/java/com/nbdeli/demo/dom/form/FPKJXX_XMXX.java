package com.nbdeli.demo.dom.form;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Administrator
 * @date 2019/3/4.
 */
@lombok.Data
@XmlRootElement(name = "FPKJXX_XMXX")
@XmlAccessorType(XmlAccessType.FIELD)
public class FPKJXX_XMXX {
    private String XMMC;
    private String XMDW;
    private String GGXH;
    private Double XMSL;
    private String HSBZ;
    private Double XMDJ;
    private String FPHXZ;
    private String SPBM;
    private String ZXBM;
    private String YHZCBS;
    private String LSLBS;
    private String ZZSTSGL;
    private Double XMJE;
    private String SL;
    private Double SE;
    private String KCE;
}
