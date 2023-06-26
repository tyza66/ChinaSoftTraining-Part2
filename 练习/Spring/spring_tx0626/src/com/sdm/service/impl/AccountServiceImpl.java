package com.sdm.service.impl;

import com.sdm.dao.AccountDao;
import com.sdm.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:22
 * Github: https://github.com/tyza66
 **/

@Service
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;
    @Override
    public boolean transfer(int fromId, int toId, double money) {
        boolean b = accountDao.reduceMoney(String.valueOf(fromId), money);
        boolean b1 = accountDao.addMoney(String.valueOf(toId), money);
        return b&&b1;
    }

    @Resource
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
