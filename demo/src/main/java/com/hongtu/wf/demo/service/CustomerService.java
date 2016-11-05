package com.hongtu.wf.demo.service;

import com.hongtu.wf.demo.helper.DatabaseHelper;
import com.hongtu.wf.demo.model.Customer;
import com.hongtu.wf.demo.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hongtu on 2016/10/21.
 */
public class CustomerService {
    private static final Logger _logger = LoggerFactory.getLogger(CustomerService.class);

    public List<Customer> getCustomerList(String keyword) {
        Connection conn = DatabaseHelper.getConnection();
        try {
            String sql = "SELECT * FROM customer";
            return DatabaseHelper.queryEntityList(Customer.class, conn, sql);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    public Customer getCustomer(Long id) {
        return null;
    }

    public boolean createCustomer(Map<String, Object> fields) {
        return false;
    }

    public boolean updateCustomer(Long id, Map<String, Object> fields) {
        return false;
    }

    public boolean deleteCustomer(Long id) {
        return false;
    }
}
