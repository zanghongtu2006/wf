package com.hongtu.wf.bean;

import com.hongtu.wf.utils.CastUtil;

import java.util.Map;

/**
 * request param
 * Created by hongtu on 16-11-9.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
