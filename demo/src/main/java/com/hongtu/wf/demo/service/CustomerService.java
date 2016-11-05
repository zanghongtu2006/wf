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
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    public Customer getCustomer(Long id) {
        String sql = "SELECT * FROM customer where id=" + id;
        return DatabaseHelper.queryEntity(Customer.class, sql);
    }

    public boolean createCustomer(Map<String, Object> fields) {
        return DatabaseHelper.insertEntity(Customer.class, fields);
    }

    public boolean updateCustomer(Long id, Map<String, Object> fields) {
        return DatabaseHelper.updateEntity(Customer.class, id, fields);
    }

    public boolean deleteCustomer(Long id) {
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
