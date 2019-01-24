package com.nbdeli.demo.config;

import java.util.Random;

/**
 * @author DuKaixiang
 * @date 2018/12/6.
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints(2,23).limit(10).forEach(System.out::println);
    }
}
