package com.icss.service.impl;

import com.icss.dao.IAccountDao;
import com.icss.service.IAccountService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    @Override
    public boolean transferAccount(String fromName, String toName, double money) {
        boolean flag1 = accountDao.reduceMoney(fromName, money);
        System.out.println(1/0);
        boolean flag2 = accountDao.addMoney(toName,money);
        return flag1 && flag2;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
