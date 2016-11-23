package com.hongtu.wf.annotation;

import java.lang.annotation.*;

/**
 * Created by hongtu on 16-11-8.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Path {
    /**
     * Request path and type
     * @return
     */
    String[] value() default {};
}
