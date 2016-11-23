package com.hongtu.wf.demo.controller;

import com.hongtu.wf.annotation.*;
import com.hongtu.wf.bean.Param;
import com.hongtu.wf.bean.View;
import com.hongtu.wf.demo.model.Customer;
import com.hongtu.wf.demo.service.CustomerService;

import java.util.List;

/**
 * Created by hongtu on 16-11-9.
 */
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;

//    @Action("get:/customer")
    @Get
    @Path("/customer")
    public View index(Param param) {
        List<Customer> customerList = customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList", customerList);
    }


}
