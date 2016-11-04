package com.hongtu.wf.demo.service;

import com.hongtu.wf.demo.model.Customer;
import com.hongtu.wf.demo.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by hongtu on 2016/10/21.
 */
public class CustomerService {
    private static final Logger _logger = LoggerFactory.getLogger(CustomerService.class);

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWOD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWOD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            _logger.error("Can not load jdbc driver", e);
        }
    }

    public List<Customer> getCustomerList(String keyword) {
        return null;
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
