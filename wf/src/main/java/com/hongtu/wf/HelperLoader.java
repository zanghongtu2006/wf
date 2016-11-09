package com.hongtu.wf;

import com.hongtu.wf.helper.BeanHelper;
import com.hongtu.wf.helper.ClassHelper;
import com.hongtu.wf.helper.ControllerHelper;
import com.hongtu.wf.helper.IocHelper;
import com.hongtu.wf.utils.ClassUtil;

/**
 * Created by hongtu on 16-11-9.
 */
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
