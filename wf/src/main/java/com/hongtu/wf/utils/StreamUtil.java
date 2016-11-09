package com.hongtu.wf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hongtu on 16-11-9.
 */
public class StreamUtil {
    private static final Logger _logger = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * get string from input stream
     * @param is
     * @return
     */
    public static String getString(InputStream is) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            _logger.error("get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }
}
