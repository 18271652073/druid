package com.nbdeli.demo.transonlineorder;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @date 2019/3/29.
 */
public class Unicode {
    public static void main(String[] args) {
        String cn = "你";
        System.out.println(cnToUnicode(cn));
        // 字符串 : \u5f00\u59cb\u4efb\u52a1 ，由于 \ 在java里是转义字符，要写出下面这种形式
        String unicode = "\\u4f60";
        System.out.println(unicodeToCn(unicode));


        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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
//        System.out.println(unicodeToCn(xml));
        System.out.println("11111111");
        System.out.println(xml);
        System.out.println(xml.replace("&lt;","<").replace("&gt;",">"));
//        System.out.println(unicodeToString(xml));
//        System.out.println("11111111");
//        System.out.println(getUnicode(xml));
//        System.out.println("11111111");
//        System.out.println(getUnicode(unicodeToString(xml)));
//        System.out.println("11111111");
//        System.out.println(unicodeToString(getUnicode(xml)));
    }

    private static String unicodeToCn(String unicode) {
        /** 以 \ u 分割，因为java注释也能识别unicode，因此中间加了一个空格*/
        String[] strs = unicode.split("\\\\u");
        String returnStr = "";
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
        }
        return returnStr;
    }

    private static String cnToUnicode(String cn) {
        char[] chars = cn.toCharArray();
        String returnStr = "";
        for (int i = 0; i < chars.length; i++) {
            returnStr += "\\u" + Integer.toString(chars[i], 16);
        }
        return returnStr;
    }


    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }

    public static String getUnicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            byte[] bytes = s.getBytes("unicode");
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);

            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
