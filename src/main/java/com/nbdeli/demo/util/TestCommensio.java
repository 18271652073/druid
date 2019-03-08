package com.nbdeli.demo.util;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Administrator
 * @date 2019/3/7.
 */
public class TestCommensio {

    /**
     * 测试 commons-io 读取文件
     * 关注 FileUtils.readLines 方法
     */
//    @Test
    public static void test01() throws IOException {
        File file = new File("E:\\count.txt");
        List<String> lines = FileUtils.readLines(file);
        int i=0;
        for(String str:lines){
            i++;
            System.out.println("第 " + i + " 行数据为：\t" + str);
        }
        i=9;//获取指定行
        System.out.println("第 " + i + " 行数据为：："+lines.get(i-1));
        System.out.println("第 " + i + " 行数据为：："+lines.get(i-1));
    }

    /**
     * 关注 FileUtils.writeStringToFile 方法
     * @throws IOException
     */
//    @Test
    public void test02() throws IOException {
        String str = "5555555555555555555555";
        String ENTER = "\n";
        // \\ 表示路径
        File file = new File("testio\\testWriteStringToFile.txt");
        //
        /**
         * 每输入一行以后，加上一个换行符
         *
         * 参数 1：文件
         * 参数 2：写入文件的字符串
         * 参数 3： true 表示追加，加在后面
         */
        FileUtils.writeStringToFile(file,str+ENTER,true);
    }

    public static void myRead() throws IOException {
        File file = new File("E:\\count.txt");
        List<String> lines = FileUtils.readLines(file);
        int i=0;
        for(String str:lines){
            i++;
            System.out.println("第 " + i + " 行数据为：\t" + str);
        }
        i=9;//获取指定行
        System.out.println("第 " + i + " 行数据为："+lines.get(i-1));
    }
    public static void main(String[] args) throws IOException {
        test01();
    }
}