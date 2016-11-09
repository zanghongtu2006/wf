package com.hongtu.wf.bean;

import java.lang.reflect.Method;

/**
 * How to handle a request
 * request will bundle in ControllerHelper
 * map(controller annotation class and action method)
 * Created by hongtu on 16-11-9.
 */
public class Handler {
    private Class<?> controllerClass;

    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
