package com.icss.dao.impl;

import com.icss.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository(value = "accountDao2")
public class AccountDaoImpl2 implements IAccountDao {

    public void selectAccountDao(){
        System.out.println("dao层查询所有的账户");
    }
}
