package com.hongtu.wf.helper;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hongtu on 16-11-11.
 */
public class TestBeanHelper {

    @Test
    public void testStaticInit() {
        assertNotNull(BeanHelper.getBeanMap());
        System.out.println(BeanHelper.getBeanMap());
    }
}
