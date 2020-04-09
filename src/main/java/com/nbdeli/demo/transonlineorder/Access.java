//package com.nbdeli.demo.transonlineorder;
//
//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service;
//import org.apache.axis.handlers.soap.SOAPService;
//
//import javax.xml.rpc.ServiceException;
//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
//
///**
// * @author Administrator
// * @date 2019/3/28.
// */
//public class Access {
//    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
////        TransOnlineOrderActionService factory=new TransOnlineOrderActionService();
////        TransOnlineOrderAction service= factory.getTransOnlineOrder();
//        //<![CDATA[  ]]>
//        String param = "<?xml version='1.0' encoding='UTF-8'?>" +
//                "<dataset>  " +
//                "<head>    " +
//                "<order_id>40942883</order_id>    " +
//                "<input_person>62120739</input_person>    " +
//                "<input_time>2019-03-27T16:01:36</input_time>    " +
//                "<extattr1>预留属性1</extattr1>  " +
//                "</head>  " +
//                "<datalist>          " +
//                "<data>        " +
//                "<order_item>1</order_item>        " +
//                "<goods_code>100002561PCS</goods_code>        " +
//                "<goods_name>得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑</goods_name>        " +
//                "<goods_price>3.07</goods_price>        " +
//                "<sale_qty>1</sale_qty>        " +
//                "<unit>PCS</unit>        " +
//                "<extattr2>预留属性2</extattr2>      " +
//                "</data>      " +
//                "</datalist>" +
//                "</dataset>";
//        StringBuffer xMLcontent = new StringBuffer("");
//        xMLcontent.append(" <![CDATA[ <?xml version='1.0' encoding='UTF-8'?>");
//        xMLcontent.append("<dataset>");
//        xMLcontent.append("<head>");
//        xMLcontent.append("<order_id>40942883</order_id>");
//        xMLcontent.append("<input_person>62120739</input_person>");
//        xMLcontent.append("<input_time>2019-03-27T16:01:36</input_time>");
//        xMLcontent.append("<extattr1>预留属性1</extattr1>");
//        xMLcontent.append("</head>");
//        xMLcontent.append("<datalist>");
//        xMLcontent.append("<data>");
//        xMLcontent.append("<order_item>1</order_item>");
//        xMLcontent.append("<goods_code>100002561PCS</goods_code>");
//        xMLcontent.append("<goods_name>得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑</goods_name>");
//        xMLcontent.append("<goods_price>3.07</goods_price>");
//        xMLcontent.append("<sale_qty>1</sale_qty>");
//        xMLcontent.append("<extattr2>预留属性2</extattr2>");
//        xMLcontent.append("</data>");
//        xMLcontent.append("</datalist>");
//        xMLcontent.append("</dataset> ]]>");
////        System.out.println(service.transOnlineOrder(param));
//
//
//        SOAPService soap = new SOAPService();
//        soap.setName("transOnlineOrder");  //此处webservice的名字
////        soap.setName("WeatherWebService");  //此处webservice的名字
//        Service service = new Service();
//        Call call = (Call) service.createCall();
//        String endpoint = "http://61.190.39.14/services/transOnlineOrder?wsdl";
//        call.setTargetEndpointAddress(new java.net.URL(endpoint));
//        call.setOperationName("transOnlineOrder");
//        call.setSOAPService(soap);
//        call.addParameter("str", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
//        call.setUseSOAPAction(true);
//        String rtnxml = (String) call.invoke(new Object[]{param});
//        System.out.println(rtnxml);
//
//
//    }
//
////    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
////        String param="<![CDATA[ <?xml version='1.0' encoding='UTF-8'?>" +
////                "<dataset>  " +
////                "<head>    " +
////                "<order_id>40942883</order_id>    " +
////                "<input_person>62120739</input_person>    " +
////                "<input_time>2019-03-27T16:01:36</input_time>    " +
////                "<extattr1>预留属性1</extattr1>  " +
////                "</head>  " +
////                "<datalist>          " +
////                "<data>        " +
////                "<order_item>1</order_item>        " +
////                "<goods_code>100002561PCS</goods_code>        " +
////                "<goods_name>得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑</goods_name>        " +
////                "<goods_price>3.07</goods_price>        " +
////                "<sale_qty>1</sale_qty>        " +
////                "<unit>PCS</unit>        " +
////                "<extattr2>预留属性2</extattr2>      " +
////                "</data>      " +
////                "</datalist>" +
////                "</dataset>  ]]>";
////        // 指出service所在完整的URL
//////        String endpoint = "http://ip:端口号/项目名/webservice/sei(即webservice接口名)?wsdl";
////        String endpoint="http://61.190.39.14/services/transOnlineOrder?wsdl";
////        //调用接口的targetNamespace
////        String targetNamespace = "transOnlineOrder";
//////        String targetNamespace = "http://webservice接口所在的包名，逆序，一直到src下";
////        //所调用接口的方法method
////        String method = "transOnlineOrder";
//////        String method = "所要调用的方法名";
////        // 创建一个服务(service)调用(call)
////        Service service = new Service();
////        Call call = (Call) service.createCall();// 通过service创建call对象
////        // 设置service所在URL
////        call.setTargetEndpointAddress(new java.net.URL(endpoint));
////        call.setOperationName(new QName(targetNamespace, method));
////        call.setUseSOAPAction(true);
////        //变量最好只是用String类型，其他类型会报错
////        call.addParameter(new QName(targetNamespace, "str"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);//设置参数名 state  第二个参数表示String类型,第三个参数表示入参
//////        call.addParameter(new QName(targetNamespace, "变量名"), org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);//设置参数名 state  第二个参数表示String类型,第三个参数表示入参
////        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型
////        // String path = targetNamespace + method;
////        // call.setSOAPActionURI(path);
////        String jsonString = (String) call.invoke(new Object[] {param});//此处为数组，有几个变量传几个变量
////        //将json字符串转换为JSON对象
////        JSON json = (JSON) JSON.parse(jsonString);
////        //将接送对象转为java对象,此处用object代替，用的时候转换为你需要是用的对象就行了
////        Object object = JSON.toJavaObject(json, Object.class);//注意别到错包com.alibaba.fastjson.JSON
////        System.out.println(jsonString);
////    }
//
////    public String ss(String url, String xml) {
////        DefaultHttpClient httpClient = new DefaultHttpClient();
////        setProxy(httpClient);
////        HttpPost httpPost = new HttpPost(url);
////        httpPost.addHeader("Content-Type", "text/xml");
////        httpPost.addHeader("SOAPAction", "Content-Type:text/xml;");
////        StringEntity entity = new StringEntity(xml, "utf-8");
////        httpPost.setEntity(entity);
////        HttpResponse response=sendRequest(httpClient,httpPost);
////        String body=parseResponse(response);
////        httpClient.getConnectionManager().shutdown();
////        return body;
////    }
//}
