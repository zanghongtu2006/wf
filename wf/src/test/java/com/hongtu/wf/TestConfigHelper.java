package com.hongtu.wf;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hongtu on 16-11-11.
 */
public class TestConfigHelper {

    @Test
    public void testGetAppBasePackage() {
        String appBasePackage = ConfigHelper.getAppBasePackage();
        String appBasePackageResult = "com.hongtu.wf.demo";
        assertEquals("app_base_package should be " + appBasePackageResult, appBasePackage, appBasePackageResult);
    }

    @Test
    public void testGetAppAsset() {
        String appAssetPath = ConfigHelper.getAppAssetPath();
        String appAssetPathResult = "/asset/";
        assertEquals("app_asset_path should be " + appAssetPathResult, appAssetPath, appAssetPathResult);
    }

    @Test
    public void testGetAppJSPPath() {
        String appJspPath = ConfigHelper.getAppJspPath();
        String appJspPathResult = "/WEB-INF/view/";
        assertEquals("app_jsp_path should be " + appJspPathResult, appJspPath, appJspPathResult);
    }
}
