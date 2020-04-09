//package com.nbdeli.demo.util;
//
//import org.apache.axis.client.Call;
//import org.apache.axis.client.Service;
//
//import javax.xml.namespace.QName;
//import javax.xml.rpc.ServiceException;
//import java.rmi.RemoteException;
//
//public class HelloWorldClient {
//
//    public static void main(String[] args) throws ServiceException,RemoteException {
//        // webService访问地址
//        String url = "http://localhost/axis/com.nbdeli.demo.util.HelloWorldService.jws";
//        // 创建服务
//        Service service = new Service();
//        // 创建调用句柄
//        Call call = (Call) service.createCall();
//        // 设置请求地址
//        call.setTargetEndpointAddress(url);
//        /**
//         * 设置调用的方法和方法的命名空间； 因为这里是手动发布到webroot目录下的，所以命名空间和请求地址一致
//         * 当然null也可以，因为本身它就没有设置命名空间，一般方法的命名空间是
//         * 包名倒写组成，如com.hoo.service,ns=http://service.hoo.com
//         */
//        call.setOperationName(new QName(null, "sayHello"));
//        /**
//         * 用call调用sayHello方法，设置请求的参数，返回的就是返回值了
//         */
//        String result = (String) call.invoke(new Object[]{"axis"});
//        System.out.println(result);
//    }
//}