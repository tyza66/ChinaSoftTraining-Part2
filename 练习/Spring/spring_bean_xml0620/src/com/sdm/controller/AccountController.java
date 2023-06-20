package com.sdm.controller;

import com.sdm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Author: tyza66
 * Date: 2023/6/20 12:58
 * Github: https://github.com/tyza66
 **/

@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    public void selectAccount(){
        System.out.println("保存了账户");
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void play(){
        accountService.selectAccount();
    }
}
