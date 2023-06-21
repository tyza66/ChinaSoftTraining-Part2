package com.sdm.dao.impl;

import com.sdm.dao.AccountDao;
import com.sdm.pojo.Account;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/21 10:47
 * Github: https://github.com/tyza66
 **/

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean insertAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccountByID(int aid) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public Account selectAccountByID(int aid) {
        return null;
    }

    @Override
    public List<Account> selectAllAccount() {
        return null;
    }
}
