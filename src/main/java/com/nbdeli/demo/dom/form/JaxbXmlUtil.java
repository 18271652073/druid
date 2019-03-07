package com.nbdeli.demo.dom.form;

import sun.misc.BASE64Encoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Jaxb工具类 xml和java类相互转换
 */
public class JaxbXmlUtil {

    public static final String DEFAULT_ENCODING = "UTF-8";

    /**
     * pojo转换成xml 默认编码UTF-8
     *
     * @param obj 待转化的对象
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj) throws Exception {
        return convertToXml(obj, DEFAULT_ENCODING);
    }

    /**
     * pojo转换成xml
     *
     * @param obj      待转化的对象
     * @param encoding 编码
     * @return xml格式字符串
     * @throws Exception JAXBException
     */
    public static String convertToXml(Object obj, String encoding) throws Exception {
        String result = null;

        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        // 指定是否使用换行和缩排对已编组 XML 数据进行格式化的属性名称。
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

        StringWriter writer = new StringWriter();
        marshaller.marshal(obj, writer);
        result = writer.toString();

        return result;
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml xml格式字符串
     * @param t   待转化的对象
     * @return 转化后的对象
     * @throws Exception JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> t) throws Exception {
        T obj = null;
        JAXBContext context = JAXBContext.newInstance(t);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        obj = (T) unmarshaller.unmarshal(new StringReader(xml));
        return obj;
    }

    public static void main(String[] args) throws Exception {
        FPKJXX_FPTXX FPKJXX_FPTXX = new FPKJXX_FPTXX();
        FPKJXX_FPTXX.setNSRSBH("111111");
        FPKJXX_FPTXX.setNSRMC("111111");
        FPKJXX_FPTXX.setDDH("111111");
        FPKJXX_FPTXX.setDDLSH("111111");
        //yyyy-MM-dd
        FPKJXX_FPTXX.setDDDATE("2019-03-04");
        FPKJXX_FPTXX.setBMB_BBH("29.0");
        FPKJXX_FPTXX.setXHF_DZ("111111");
        FPKJXX_FPTXX.setXHF_DH("111111");
        FPKJXX_FPTXX.setXHF_YHZH("111111");
        FPKJXX_FPTXX.setGHFMC("111111");
        FPKJXX_FPTXX.setKPLY("111111");
        FPKJXX_FPTXX.setKPY("111111");
        FPKJXX_FPTXX.setKPLX("111111");
        FPKJXX_FPTXX.setKPHJJE("111111");
        FPKJXX_FPTXX.setHJBHSJE("111111");
        FPKJXX_FPTXX.setHJSE("111111");


        FPKJXX_XMXXS FPKJXX_XMXXS = new FPKJXX_XMXXS();
        FPKJXX_XMXX fpkjxx_xmxx = new FPKJXX_XMXX();
        fpkjxx_xmxx.setXMMC("11111");
        fpkjxx_xmxx.setHSBZ("0");
        fpkjxx_xmxx.setFPHXZ("0");
        fpkjxx_xmxx.setSPBM("11111");
        fpkjxx_xmxx.setYHZCBS("0");
        fpkjxx_xmxx.setYHZCBS("0");
        fpkjxx_xmxx.setXMJE(1.11);
        fpkjxx_xmxx.setSL("0");
        fpkjxx_xmxx.setSE(0.11);
        List<FPKJXX_XMXX> FPKJXX_XMXX = new ArrayList<>();
        FPKJXX_XMXX.add(fpkjxx_xmxx);
        FPKJXX_XMXXS.setFPKJXX_XMXXS(FPKJXX_XMXX);
        REQUEST_FPKJXX request_fpkjxx = new REQUEST_FPKJXX();
        request_fpkjxx.setFPKJXX_FPTXX(FPKJXX_FPTXX);
        request_fpkjxx.setFPKJXX_XMXXS(FPKJXX_XMXXS);
        String request_fpkjxxXML = convertToXml(request_fpkjxx, "UTF-8");
        System.out.println("--------------");
        System.out.println(request_fpkjxxXML);
        String aesEncryptStr = AESUtils.encrypt(request_fpkjxxXML, "WuMlCJRN8zO886dw");
        String baseEncryptStr = new BASE64Encoder().encode(aesEncryptStr.getBytes());
        Data Data = new Data();
        Data.setContent(baseEncryptStr);

        GlobalInfo globalInfo = new GlobalInfo();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(date);
        globalInfo.setRequestTime(format);
        globalInfo.setInterfaceCode("DZFPKJ");
        globalInfo.setToken("330201999999868");
        globalInfo.setVersion("4.0");

        Interface interfaceEntity = new Interface();
        interfaceEntity.setGlobalInfo(globalInfo);
        interfaceEntity.setData(Data);
        String interfaceEntityXML = convertToXml(interfaceEntity, "UTF-8");
        System.out.println("--------------");
        System.out.println(interfaceEntityXML);
        String RequestParam = new BASE64Encoder().encode(interfaceEntityXML.getBytes());
        System.out.println("--------------");
        System.out.println(RequestParam);
        String Signature = SHAUtil.hamcsha1(RequestParam.getBytes(), "I7GBo4w9E6dmGlLVJMaVtXrhbNqp4KBh".getBytes()).toLowerCase();
        Map<String, String> map = new HashMap<>();
        map.put("RequestParam", RequestParam);
        map.put("Signature", Signature);
        Map paramMap = MapUtil.convert2HashMap("RequestParam", RequestParam, "Signature", Signature);
        String resultStr = HttpUtil.doPostOfStringResult("http://test2.51fapiaonb.cn:4011/DZFP_Four", paramMap, "utf-8");
        System.out.println("--------------");
        System.out.println(resultStr);
        System.out.println("--------------");
        System.out.println(SHAUtil.hamcsha1("YWJjZDEyMzQ=".getBytes(), "I7GBo4w9E6dmGlLVJMaVtXrhbNqp4KBh".getBytes()).toLowerCase());

    }
}