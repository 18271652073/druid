//package com.nbdeli.demo.transonlineorder;
//
//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service;
//
//import javax.xml.namespace.QName;
//import javax.xml.rpc.ServiceException;
//import java.net.MalformedURLException;
//import java.rmi.RemoteException;
//
///**
// * @author Administrator
// * @date 2019/3/29.
// */
//public class One {
//    public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
////        Service service = new Service();
////        Call call = (Call) service.createCall();
////        String endpoint = "http://192.168.112.71:8000/sap/bc/soap/WSdl/?services=ZFM_TMS_ZX006";
////        call.setTargetEndpointAddress(new java.net.URL(endpoint));
//////        call.setOperationName(new QName("http://service.demo.nbdeli.com/","sayHello"));
////        call.setOperationName(new QName("urn:sap-com:document:sap:rfc:functions","ZFM_TMS_ZX006"));
//////        call.setOperationName("ZFM_TMS_ZX006");
////        call.addParameter("IV_VBELN", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
////        call.addParameter("IV_ZQSRQ", org.apache.axis.encoding.XMLType.XSD_DATE, javax.xml.rpc.ParameterMode.IN);
////        call.addParameter("IV_ZSJSC", org.apache.axis.encoding.XMLType.XSD_FLOAT, javax.xml.rpc.ParameterMode.IN);
////        call.addParameter("IV_ZYSSC", org.apache.axis.encoding.XMLType.XSD_FLOAT, javax.xml.rpc.ParameterMode.IN);
////        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
////        call.setUseSOAPAction(true);
////        String rtnxml = (String) call.invoke(new Object[]{"aaaa",new Date(),4096,4096});
////        System.out.println(rtnxml);
//        Service service = new Service();
//        Call call = (Call) service.createCall();
//        String endpoint = "http://localhost:8989/webservcie?wsdl";
//        call.setTargetEndpointAddress(new java.net.URL(endpoint));
//        call.setOperationName(new QName("http://service.demo.nbdeli.com/","sayHello"));
//        call.addParameter("name", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
//        call.addParameter("passWord", org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
//        call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
//        call.setUseSOAPAction(true);
//        String rtnxml = (String) call.invoke(new Object[]{"dkx","123"});
//        System.out.println(rtnxml);
//    }
//}
