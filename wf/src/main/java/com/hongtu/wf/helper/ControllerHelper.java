package com.hongtu.wf.helper;

import com.hongtu.wf.annotation.*;
import com.hongtu.wf.bean.Handler;
import com.hongtu.wf.bean.Request;
import com.hongtu.wf.utils.ArrayUtil;
import com.hongtu.wf.utils.CollectionUtil;
import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * map(request -> handler)
 * Created by hongtu on 16-11-9.
 */
public final class ControllerHelper {
    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();
    private static final Map<Request, Handler> GET_ACTION_MAP = new HashMap<Request, Handler>();
    private static final Map<Request, Handler> POST_ACTION_MAP = new HashMap<Request, Handler>();
    private static final Map<Request, Handler> DELETE_ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtil.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtil.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(Path.class)) {
                            Path action = method.getAnnotation(Path.class);
                            String[] mappings = action.value();
                            for (String mapping : mappings) {
                                Handler handler = new Handler(controllerClass, method);
                                if (mapping.matches("/\\w*")) {
                                    String requestPath = mapping;
                                    Request request = null;
                                    if (method.isAnnotationPresent(Get.class)) {
                                        request = new Request("get", requestPath);
                                    }
                                    if (method.isAnnotationPresent(Post.class)) {
                                        request = new Request("post", requestPath);
                                    }
                                    if (method.isAnnotationPresent(Delete.class)) {
                                        request = new Request("delete", requestPath);
                                    }
                                    if (request != null) {
                                        ACTION_MAP.put(request, handler);
                                    }
                                }
                            }
                        }
//                        if (method.isAnnotationPresent(Action.class)) {
//                            Action action = method.getAnnotation(Action.class);
//                            String mapping = action.value();
//                            //check url role
//                            if (mapping.matches("\\w+:/\\w*")) {
//                                String[] array = mapping.split(":");
//                                if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
//                                    String requestMethod = array[0];//get,post...
//                                    String requestPath = array[1];
//                                    Request request = new Request(requestMethod, requestPath);
//                                    Handler handler = new Handler(controllerClass, method);
//                                    ACTION_MAP.put(request, handler);
//                                }
//                            }
//                        }
                    }
                }
            }
        }
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return ACTION_MAP.get(request);
    }
}
