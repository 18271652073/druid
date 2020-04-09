package com.nbdeli.demo.util;

import com.nbdeli.demo.dom.blob.entity.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对象工具类
 *
 * @author lenic 2013-4-27
 */
public abstract class ObjectUtil {

    private static Logger logger = LoggerFactory.getLogger(ObjectUtil.class);

    /**
     * 若对象为空则返回new对象，否则不变
     *
     * @param value
     * @param targetClass
     * @return
     */
    public static <T> T trim(T value, Class<T> targetClass) {
        if (value == null && targetClass != null) {
            try {
                value = targetClass.newInstance();
            } catch (Exception e) {
                logger.error("", e);
            }
        }
        return value;
    }

    public static <T> T newObject(Class<T> targetClass) {
        try {
            return targetClass.newInstance();
        } catch (Exception e) {
            logger.error("", e);
        }

        return null;
    }

    public static void main(String[] args) {
        SystemConstant systemConstant = new SystemConstant();
        SystemConstant systemConstantNull = null;
        SystemConstant map = trim(systemConstant, SystemConstant.class);
        SystemConstant mapNull = trim(systemConstantNull, SystemConstant.class);
        System.out.println(mapNull);
    }
}