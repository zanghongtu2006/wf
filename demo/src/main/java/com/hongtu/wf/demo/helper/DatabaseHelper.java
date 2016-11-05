package com.hongtu.wf.demo.helper;

import com.hongtu.wf.demo.utils.CollectionUtil;
import com.hongtu.wf.demo.utils.PropsUtil;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hongtu on 16-11-5.
 */
public final class DatabaseHelper {
    private static final Logger _logger = LoggerFactory.getLogger(DatabaseHelper.class);

//    private static final String DRIVER;
//    private static final String URL;
//    private static final String USERNAME;
//    private static final String PASSWORD;

    private static final QueryRunner QUERY_RUNNER;

    private static final ThreadLocal<Connection> CONNECTION_HOLDER;

    private static final BasicDataSource DATA_SOURCE;// use datasource to manage connection

    static {
        CONNECTION_HOLDER = new ThreadLocal<Connection>();
        QUERY_RUNNER = new QueryRunner();

        Properties conf = PropsUtil.loadProps("config.properties");
        String driver = conf.getProperty("jdbc.driver");
        String url = conf.getProperty("jdbc.url");
        String username = conf.getProperty("jdbc.username");
        String password = conf.getProperty("jdbc.password");

        DATA_SOURCE = new BasicDataSource();
        DATA_SOURCE.setDriverClassName(driver);
        DATA_SOURCE.setUrl(url);
        DATA_SOURCE.setUsername(username);
        DATA_SOURCE.setPassword(password);
    }

    public static Connection getConnection() {
        Connection conn = CONNECTION_HOLDER.get(); // try get conenction in ThreadLocal
                                                    // or create a new one and put it into ThreadLocal
        if (conn == null) {
            try {
                conn = DATA_SOURCE.getConnection();
            } catch (SQLException e) {
                _logger.error("get connection failure", e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }

        return conn;
    }

    public static <T> List<T> queryEntityList(Class<T> entityClass, String sql, Object... params) {
        List<T> entityList;
        try {
            Connection conn = getConnection();
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            _logger.error("query entity list failure", e);
            throw new RuntimeException(e);
        }
        return entityList;
    }

    public static <T> T queryEntity(Class<T> entityClass, String sql, Object... params) {
        T entity;
        try {
            Connection conn = getConnection();
            entity = QUERY_RUNNER.query(conn, sql, new BeanHandler<T>(entityClass), params);
        } catch (SQLException e) {
            _logger.error("query entity failure", e);
            throw new RuntimeException(e);
        }
        return entity;
    }

    /**
     * execute any sql for query
     */
    public static List<Map<String, Object>> executeQuery(String sql, Object... params) {
        List<Map<String, Object>> result;
        try {
            Connection conn = getConnection();
            result = QUERY_RUNNER.query(conn, sql, new MapListHandler(), params);
        } catch (SQLException e) {
            _logger.error("execute query failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * execute insert, update, delete
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object... params) {
        int rows = 0;
        try {
            Connection conn = getConnection();
            rows = QUERY_RUNNER.update(conn, sql, params);
        } catch (SQLException e) {
            _logger.error("execute update failure", e);
            throw new RuntimeException(e);
        }
        return rows;
    }

    public static <T> boolean insertEntity(Class<T> entityClass, Map<String, Object> fieldMap) {
        if (CollectionUtil.isEmpty(fieldMap)) {
            _logger.error("can not insert entity : fieldMap is empty");
            return false;
        }

        String sql = "INSERT INTO " + getTableName(entityClass);
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append(", ");
            values.append("?, ");
        }
        columns.replace(columns.lastIndexOf(", "), columns.length(), ")");
        values.replace(values.lastIndexOf(", "), values.length(), ")");
        sql += columns + " VALUES " + values;

        Object[] params = fieldMap.values().toArray();
        return executeUpdate(sql, params) == 1;
    }

    public static <T> boolean updateEntity(Class<T> entityClass, long id, Map<String, Object> fieldMap) {
        if (CollectionUtil.isEmpty(fieldMap)) {
            _logger.error("can not update entity: fieldMap is null");
            return false;
        }

        String sql = "UPDATE " + getTableName(entityClass) + " SET ";
        StringBuilder columns = new StringBuilder();
        for (String fieldName : fieldMap.keySet()) {
            columns.append(fieldName).append("=?, ");
        }
        sql += columns.substring(0, columns.lastIndexOf(", ")) + " WHERE id=?";

        List<Object> paramList = new ArrayList<Object>();
        paramList.addAll(fieldMap.values());
        paramList.add(id);
        Object[] params = paramList.toArray();

        return executeUpdate(sql, params) == 1;
    }

    public static <T> boolean deleteEntity(Class<T> entityClass, long id) {
        String sql = "DELETE FROM " + getTableName(entityClass) + " WHERE id=?";
        return executeUpdate(sql, id) == 1;
    }

    /**
     * return tableName which is the Class Name
     * @param entityClass
     * @param <T>
     * @return
     */
    private static <T> String getTableName(Class<T> entityClass) {
        return entityClass.getSimpleName();
    }

    /**
     * execute all sql in a file
     * @param filePath
     */
    public static void executeSqlFile(String filePath) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            String sql;
            while ((sql = reader.readLine()) != null) {
                executeUpdate(sql);
            }
        } catch (IOException e) {
            _logger.error("execute sql file failure", e);
            throw new RuntimeException(e);
        }
    }

}
