package com.sdm.service.impl;

import com.sdm.dao.AccountDao;
import com.sdm.dao.impl.AccountDaoImpl;
import com.sdm.service.AccountService;

/**
 * Author: tyza66
 * Date: 2023/6/20 13:09
 * Github: https://github.com/tyza66
 **/

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void selectAccount() {
        accountDao.getDog();
    }
}
