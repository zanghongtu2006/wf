package com.hongtu.wf.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hongtu on 2016/11/29.
 */
public class DBUtil {
    private static final Logger _logger = LoggerFactory.getLogger(DBUtil.class);

    private static final String driver = "om.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/wfdemo";
    private static final String username = "root";
    private static final String password = "password";

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    public static Connection getConnection() {
        Connection conn = connContainer.get();
        try {
            if (conn == null) {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
            }
        } catch (Exception e) {
            _logger.error("Get connection failure", e);
        } finally {
            connContainer.set(conn);
        }
        return conn;
    }

    public static void closeConnection() {
        Connection conn = connContainer.get();
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            _logger.error("Close connection failure", e);
        } finally {
            connContainer.remove();
        }
    }
}
