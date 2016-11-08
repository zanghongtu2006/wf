package com.hongtu.wf.utils;

import org.omg.CORBA.FieldNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Created by hongtu on 16-11-9.
 */
public class ReflectionUtil {
    private static final Logger _logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * create instance
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            _logger.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * set field value
     * @param obj
     * @param field
     * @param value
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            _logger.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
