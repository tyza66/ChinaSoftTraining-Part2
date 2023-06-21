package com.sdm.dao.impl;

import com.sdm.dao.AccountDao;
import com.sdm.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/21 10:47
 * Github: https://github.com/tyza66
 **/

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insertAccount(Account account) {
        return jdbcTemplate.update("insert into \"account_sdm\" values (?,?,?)", account.getAid(), account.getName(), account.getMoney()) > 0 ? true : false;
    }

    @Override
    public boolean deleteAccountByID(int aid) {
        return jdbcTemplate.update("delete from \"account_sdm\" where \"AID\" = ?", aid) > 0 ? true : false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return jdbcTemplate.update("update \"account_sdm\" set \"MONEY\" = ? where \"AID\" = ?",account.getMoney() ,account.getAid()) > 0 ? true : false;
    }

    @Override
    public Account selectAccountByID(int aid) {
        return null;
    }

    @Override
    public List<Account> selectAllAccount() {
        List<Account> query = jdbcTemplate.query("select * from \"account_sdm\"", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setAid(resultSet.getInt("AID"));
                account.setName(resultSet.getString("NAME"));
                account.setMoney(resultSet.getString("MONEY"));
                return account;
            }
        });
        return query;
    }
}
