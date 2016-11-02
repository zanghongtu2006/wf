package com.hongtu.wf.demo.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by hongtu on 16-10-29.
 */
public class StringUtil {
    /**
     * check if str is empty or str.trim() is empty
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
