package com.hongtu.wf.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by hongtu on 16-11-9.
 */
public class ArrayUtil {
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }
}
