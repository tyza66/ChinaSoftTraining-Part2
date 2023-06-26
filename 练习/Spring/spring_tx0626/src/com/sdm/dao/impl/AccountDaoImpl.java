package com.sdm.dao.impl;

import com.sdm.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:17
 * Github: https://github.com/tyza66
 **/

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean reduceMoney(int id, double money) {
        return jdbcTemplate.update("update account set money = money - ? where id = ?", money, id) > 0;
    }

    @Override
    public boolean addMoney(int id, double money) {
        return jdbcTemplate.update("update account set money = money + ? where id = ?", money, id) > 0;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
