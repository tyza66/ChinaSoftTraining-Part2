package com.icss.dao.impl;

import com.icss.dao.IAccountDao;
import com.icss.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean insertAccount(Account account) {
        return jdbcTemplate.update("insert into account values(?,?,?)",account.getAid(),account.getName(),account.getMoney()) > 0 ? true : false;
    }

    @Override
    public boolean deleteAccountById(int aid) {
        return jdbcTemplate.update("delete from account where aid = ?",aid) > 0 ? true : false;
    }

    @Override
    public boolean updateAccountById(Account account) {
        return jdbcTemplate.update("update account set name = ?,money = ? where aid = ?",account.getName(),account.getMoney(),account.getAid()) > 0 ? true : false;
    }

    @Override
    public Account selectAccountById(int aid) {
        List<Account> list = jdbcTemplate.query("select * from account where aid = ?", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                account.setAid(resultSet.getInt("aid"));
                account.setName(resultSet.getString("name"));
                account.setMoney(resultSet.getInt("money"));
                return account;
            }
        },aid);

        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Account> selectAllAccount() {
       List<Account> list =  jdbcTemplate.query("select * from account", new RowMapper<Account>() {
           @Override
           public Account mapRow(ResultSet resultSet, int i) throws SQLException {
               Account account = new Account();
               account.setAid(resultSet.getInt("aid"));
               account.setName(resultSet.getString("name"));
               account.setMoney(resultSet.getInt("money"));
               return account;
           }
       });
      return list;
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
