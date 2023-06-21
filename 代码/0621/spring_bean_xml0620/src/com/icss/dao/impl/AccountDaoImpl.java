package com.icss.dao.impl;

import com.icss.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao1")
public class AccountDaoImpl implements IAccountDao {

    public void selectAccountDao(){
        System.out.println("dao层查询所有的账户");
    }
}
