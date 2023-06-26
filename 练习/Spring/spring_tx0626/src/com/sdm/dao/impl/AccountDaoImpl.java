package com.sdm.dao.impl;

import com.sdm.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:17
 * Github: https://github.com/tyza66
 **/

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean reduceMoney(String id, double money) {
        return jdbcTemplate.update("update \"account_sdm\" set money = money - ? where AID = ?", money, id) > 0;
    }

    @Override
    public boolean addMoney(String id, double money) {
        return jdbcTemplate.update("update \"account_sdm\" set money = money + ? where AID = ?", money, id) > 0;
    }

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
