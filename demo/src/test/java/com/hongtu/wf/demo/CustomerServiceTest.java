package com.hongtu.wf.demo;

import com.hongtu.wf.demo.model.Customer;
import com.hongtu.wf.demo.service.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by hongtu on 16-10-28.
 * CustomerService Unit Test
 */
public class CustomerServiceTest {
    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

    @Before
    public void init() {
        //TODO Init Database
    }

    @Test
    public void getCustomerListTest() {
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    private void getCustomerTest() {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

}
