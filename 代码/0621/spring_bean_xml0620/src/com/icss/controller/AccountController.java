package com.icss.controller;

import com.icss.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AccountController {

//    Controller调用Service 调用Dao

//    创建service对象
    @Autowired
    private IAccountService service;

    public void selectAccount(){
        service.selectAccountDao();
    }

}
