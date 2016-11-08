package com.hongtu.wf.demo.utils;

import com.hongtu.wf.utils.StringUtil;

/**
 * Created by hongtu on 16-10-29.
 */
public class CastUtil {
    /**
     * cast to String, default ""
     * @param obj
     * @return
     */
    public static String castString(Object obj) {
        return CastUtil.castString(obj, "");
    }

    /**
     * cast to String, default [defaultValue]
     * @param obj
     * @param defaltValue
     * @return
     */
    public static String castString(Object obj, String defaltValue) {
        return obj != null ? String.valueOf(obj) : defaltValue;
    }

    /**
     * cast to double, default 0
     * @param obj
     * @return
     */
    public static double castDouble(Object obj) {
        return CastUtil.castDouble(obj, 0);
    }

    /**
     * cast to double, default [defaultValue]
     * @param obj
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object obj, int defaultValue) {
        double value = defaultValue;
        if (obj != null) {
            String strValue = String.valueOf(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    value = Double.parseDouble(strValue);
                } catch (NumberFormatException e) {
                    //do nothing
                }
            }
        }
        return value;
    }

    /**
     * cast to long, default 0
     * @param obj
     * @return
     */
    public static long castLong(Object obj) {
        return castLong(obj, 0);
    }

    /**
     * cast to long, default [defaultValue]
     * @param obj
     * @param defaultValue
     * @return
     */
    public static long castLong(Object obj, long defaultValue) {
        long value = defaultValue;
        if (obj != null) {
            String strValue = String.valueOf(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    value = Long.parseLong(strValue);
                } catch (NumberFormatException e) {
                    // do nothing
                }
            }
        }
        return value;
    }

    /**
     * cast to int, default 0
     * @param obj
     * @return
     */
    public static int castInt(Object obj) {
        return CastUtil.castInt(obj, 0);
    }

    /**
     * cast to int, default [defaultValue]
     * @param obj
     * @param defaultValue
     * @return
     */
    public static int castInt(Object obj, int defaultValue) {
        int value = defaultValue;
        if (obj != null) {
            String strValue = castString(obj);
            if (StringUtil.isNotEmpty(strValue)) {
                try {
                    value = Integer.parseInt(strValue);
                } catch (NumberFormatException e) {
                    // do nothing
                }
            }
        }
        return value;
    }

    /**
     * cast to boolean, default false
     * @param obj
     * @return
     */
    public static boolean castBoolean(Object obj) {
        return CastUtil.castBoolean(obj, false);
    }

    /**
     * cast to boolean, default [defaultValue]
     * @param obj
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object obj, boolean defaultValue) {
        boolean value = defaultValue;
        if (obj != null) {
            value = Boolean.parseBoolean(castString(obj));
        }
        return value;
    }

}
