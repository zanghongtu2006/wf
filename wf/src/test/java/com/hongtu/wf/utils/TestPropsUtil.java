package com.hongtu.wf.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.*;

/**
 * Created by hongtu on 16-11-9.
 */
public class TestPropsUtil {
    private static Properties properties;

    @Before
    public void init() {
        properties = PropsUtil.loadProps("config.properties");
    }

    @Test
    public void testLoadProps() {
//        Properties properties = PropsUtil.loadProps("config.properties");
        System.out.println(properties);
    }

    @Test
    public void testGetString() {
        String jspPath = PropsUtil.getString(properties, "wf.app.jsp_path");
        String jspPathResult = "/WEB-INF/view/";
        String asset = PropsUtil.getString(properties, "wf.app.asset_path");
        String assetResult = "/asset/";
        assertNotNull(jspPath);
        assertNotNull(asset);
        assertEquals("wf.app.jsp_path should be \"/WEB-INF/view/\"", jspPath, jspPathResult);
        assertEquals("wf.app.asset_path should be " + assetResult, asset, assetResult);
    }

    @Test
    public void testGetStringFailed() {
        assertNotNull(PropsUtil.getString(properties, "wf.app.jsp_path"));
        assertArrayEquals("Key \"notexist\" should returns \"\"", PropsUtil.getString(properties, "notexist").getBytes(), "".getBytes());
    }
}
