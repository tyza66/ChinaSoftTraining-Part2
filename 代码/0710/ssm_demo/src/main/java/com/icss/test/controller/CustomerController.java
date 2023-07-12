package com.icss.test.controller;

import com.icss.test.common.R;
import com.icss.test.pojo.Customer;
import com.icss.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 登录功能
     * @param cname 用户名
     * @param cpwd  密码
     * @return R 响应数据
     */
    @PostMapping("/login")
    public R login(String cname, String cpwd){
        Customer customer = customerService.selectCusByNameAndPwd(cname, cpwd);
        if (customer != null) {
            return R.ok("登录成功",customer);
        } else {
            return R.fail("用户名或者密码不正确");
        }
    }

    @PostMapping("/register")
    public R register(Customer customer){
       if(customerService.registerCus(customer)){
           return R.ok("注册成功");
       }else {
           return R.fail("注册失败");
       }
    }
}
