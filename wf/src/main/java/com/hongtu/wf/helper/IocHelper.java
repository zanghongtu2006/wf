package com.hongtu.wf.helper;

import com.hongtu.wf.annotation.Inject;
import com.hongtu.wf.utils.ArrayUtil;
import com.hongtu.wf.utils.CollectionUtil;
import com.hongtu.wf.utils.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by hongtu on 16-11-9.
 */
public final class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntity : beanMap.entrySet()) {
                Class<?> beanClass = beanEntity.getKey();
                Object beanInstance = beanEntity.getValue();
                Field[] beanFields = beanClass.getFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
