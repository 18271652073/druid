package com.nbdeli.demo.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/9/3.
 */
public class HttpHelp {

    public static byte[] doPost(String url, Map headerMap, Map parameterMap, String paramCharset, String proxyUrl, int proxyPort) {
        byte[] content = null;
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod = new PostMethod(url);
        if (StringUtils.isNotBlank(paramCharset)) {
            postMethod.getParams().setContentCharset(paramCharset);
            postMethod.getParams().setHttpElementCharset(paramCharset);
        }
        if (headerMap != null) {
            Iterator iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                postMethod.addRequestHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        if (StringUtils.isNotBlank(proxyUrl)) {
            httpClient.getHostConfiguration().setProxy(proxyUrl, proxyPort);
        }
        Iterator iterator = parameterMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            postMethod.addParameter(key, (String) parameterMap.get(key));
        }
        //设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        //postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER , new DefaultHttpMethodRetryHandler());
        InputStream inputStream = null;
        try {
            if (httpClient.executeMethod(postMethod) == HttpStatus.SC_OK) {
                //读取内容
                inputStream = postMethod.getResponseBodyAsStream();
                content = IOUtils.toByteArray(inputStream);
            } else {
                System.err.println("Method failed: " + postMethod.getStatusLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            postMethod.releaseConnection();
        }
        return content;
    }

    public static byte[] doGet(String url, Map headerMap, String proxyUrl, int proxyPort) {
        byte[] content = null;
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        if (headerMap != null) {
            Iterator iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                getMethod.addRequestHeader(entry.getKey().toString(), entry.getValue().toString());
            }
        }
        if (StringUtils.isNotBlank(proxyUrl)) {
            httpClient.getHostConfiguration().setProxy(proxyUrl, proxyPort);
        }
        //设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 10000);
        //postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER , new DefaultHttpMethodRetryHandler());
        InputStream inputStream = null;
        try {
            if (httpClient.executeMethod(getMethod) == HttpStatus.SC_OK) {
                //读取内容
                inputStream = getMethod.getResponseBodyAsStream();
                content = IOUtils.toByteArray(inputStream);
            } else {
                System.err.println("Method failed: " + getMethod.getStatusLine());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
            getMethod.releaseConnection();
        }
        return content;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("wd", "nima");
//        byte[] a = doGet("http://www.baidu.com", map, null, 0);
//        System.out.println("-------------------" + new String(a));
////        Date date=new Date();
////        System.out.println();
////        System.out.println(date.toString());
////        System.out.println(new java.sql.Date(2099/01/01));

        String url = "http://localhost:5082/zhong";
        Map map = new HashMap<>();
        String param = "<![CDATA[ <?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<dataset>\n" +
                "  <head>\n" +
                "    <order_id>40942883</order_id>\n" +
                "    <input_person>62120739</input_person>\n" +
                "    <input_time>2019-03-27T16:01:36</input_time>\n" +
                "    <extattr1>MULE预留属性1</extattr1>\n" +
                "  </head>\n" +
                "  <datalist>\n" +
                "    \n" +
                "      <data>\n" +
                "        <order_item>1</order_item>\n" +
                "        <goods_code>100002561PCS</goods_code>\n" +
                "        <goods_name>得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑</goods_name>\n" +
                "        <goods_price>3.07</goods_price>\n" +
                "        <sale_qty>1</sale_qty>\n" +
                "        <unit>PCS</unit>\n" +
                "        <extattr2>MULE预留属性2</extattr2>\n" +
                "      </data>\n" +
                "    \n" +
                "  </datalist>\n" +
                "</dataset> ]]>";
        map.put("str", param);
        byte[] a = doPost(url, null, map, "utf-8", "", 0);
//        byte[] a = doGet(url+"?str="+param, map, null, 0);
//        byte[] a = doGet(url, map, null, 0);
        String result = new String(a, "utf-8");
        System.out.println("111111");
        System.out.println(result);
    }

}
