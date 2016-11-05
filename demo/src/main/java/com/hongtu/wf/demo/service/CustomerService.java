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
        Connection conn = null;
        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM customer";
            conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            _logger.error("get customer failed ", e);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
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
