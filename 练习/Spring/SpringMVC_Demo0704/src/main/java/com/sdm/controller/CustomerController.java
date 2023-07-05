package com.sdm.controller;

import com.sdm.pojo.Customer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/7/5 12:49
 * Github: https://github.com/tyza66
 **/

@RestController
public class CustomerController {

    @PostMapping("/customer")
    private boolean add(@RequestBody Customer customer){
        System.out.println(customer);
        return true;
    }
}
