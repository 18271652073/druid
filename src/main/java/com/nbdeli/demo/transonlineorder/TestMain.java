package com.nbdeli.demo.transonlineorder;

import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @date 2019/3/29.
 */
public class TestMain {
    public static void main(String[] args) {
        JSONObject node=new JSONObject();
        String param = "<?xml version='1.0' encoding='UTF-8'?>" +
                "<dataset>  " +
                "<head>    " +
                "<order_id>40942883</order_id>    " +
                "<input_person>62120739</input_person>    " +
                "<input_time>2019-03-27T16:01:36</input_time>    " +
                "<extattr1>预留属性1</extattr1>  " +
                "</head>  " +
                "<datalist>          " +
                "<data>        " +
                "<order_item>1</order_item>        " +
                "<goods_code>100002561PCS</goods_code>        " +
                "<goods_name>得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑</goods_name>        " +
                "<goods_price>3.07</goods_price>        " +
                "<sale_qty>1</sale_qty>        " +
                "<unit>PCS</unit>        " +
                "<extattr2>预留属性2</extattr2>      " +
                "</data>      " +
                "</datalist>" +
                "</dataset>";
        node.put("str",param);
//        System.out.println(node.toString());

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<m:transOnlineOrder xmlns:m=\"http://61.190.39.14/\"><str>&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;\n" +
                "&lt;dataset&gt;\n" +
                "  &lt;head&gt;\n" +
                "    &lt;order_id&gt;40942883&lt;/order_id&gt;\n" +
                "    &lt;input_person&gt;62120739&lt;/input_person&gt;\n" +
                "    &lt;input_time&gt;2019-03-27T16:01:36&lt;/input_time&gt;\n" +
                "    &lt;extattr1&gt;预留属性1&lt;/extattr1&gt;\n" +
                "  &lt;/head&gt;\n" +
                "  &lt;datalist&gt;\n" +
                "    \n" +
                "      &lt;data&gt;\n" +
                "        &lt;order_item&gt;1&lt;/order_item&gt;\n" +
                "        &lt;goods_code&gt;100002561PCS&lt;/goods_code&gt;\n" +
                "        &lt;goods_name&gt;得力 9543 长尾票夹 32mm 12只/筒 （单位：盒） 黑&lt;/goods_name&gt;\n" +
                "        &lt;goods_price&gt;3.07&lt;/goods_price&gt;\n" +
                "        &lt;sale_qty&gt;1&lt;/sale_qty&gt;\n" +
                "        &lt;unit&gt;PCS&lt;/unit&gt;\n" +
                "        &lt;extattr2&gt;预留属性2&lt;/extattr2&gt;\n" +
                "      &lt;/data&gt;\n" +
                "    \n" +
                "  &lt;/datalist&gt;\n" +
                "&lt;/dataset&gt;</str></m:transOnlineOrder>";
        System.out.println(unicodeToString(xml));


    }

    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }
}
