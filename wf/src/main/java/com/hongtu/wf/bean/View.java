package com.hongtu.wf.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * view: jsp file
 * Created by hongtu on 16-11-9.
 */
public class View {
    private String path;

    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<String, Object>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
