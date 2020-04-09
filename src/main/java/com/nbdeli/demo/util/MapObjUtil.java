package com.nbdeli.demo.util;

/**
 * @author Dukaixiang
 * @date 2019/5/7.
 * @Version 1.0
 */

import com.nbdeli.demo.dom.blob.entity.SystemConstant;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class MapObjUtil {

    /**
     * 实体对象转成Map
     *
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map转成实体对象
     * map为空的时候得到的实体也会为空null
     *
     * @param map   map实体对象包含属性
     * @param clazz 实体对象类型
     * @return
     */
    public static <T> T map2Object(Map<String, Object> map, Class<T> clazz) {
        if (map == null) {
            return null;
        }
        T obj = null;
        try {
            obj = clazz.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        SystemConstant systemConstant = new SystemConstant();
        //map转实体
//        Map map=new HashMap<>();
//        map.put("id",1);
//        map.put("constantType","test1");
//        map.put("typeName","test2");
//        map.put("constantKey","test3");
//        map.put("constantValue","test4");
//        map.put("addTime",new Date());
//        SystemConstant systemConstant1=map2Object(map,SystemConstant.class);
//        System.out.println(systemConstant1);
        //实体转map
//        systemConstant.setId(1);
//        systemConstant.setConstantType("param1");
//        systemConstant.setTypeName("param2");
//        systemConstant.setConstantKey("param3");
//        systemConstant.setConstantValue("param4");
//        systemConstant.setAddTime(new Date());
//        Map map1=object2Map(systemConstant);
//        System.out.println(map1);
    }
}