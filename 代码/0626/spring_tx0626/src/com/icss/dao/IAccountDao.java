package com.icss.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public interface IAccountDao {
//    转账功能
//    单一数据库操作
    boolean reduceMoney(String fromName,double money);

    boolean addMoney(String toName,double money);


}
