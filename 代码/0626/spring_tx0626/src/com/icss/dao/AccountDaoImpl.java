package com.icss.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDaoImpl implements IAccountDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean reduceMoney(String fromName, double money) {
        return jdbcTemplate.update("update account set money = money - ? where name = ?",money,fromName) > 0 ? true : false;
    }

    @Override
    public boolean addMoney(String toName, double money) {
        return jdbcTemplate.update("update account set money = money + ? where name = ?",money,toName) > 0 ? true : false;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
