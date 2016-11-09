package com.hongtu.wf.utils;

import com.hongtu.wf.bean.Param;
import org.omg.CORBA.FieldNameHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static Object invokeMethod(Object controllerBean, Method actionMethod, Param param) {
        Object result = null;
        try {
            result = actionMethod.invoke(controllerBean, param);
        } catch (Exception e) {
            _logger.error("invode method " + actionMethod + " failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }
}
