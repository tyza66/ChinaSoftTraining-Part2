package com.sdm.dao.impl;

import com.sdm.dao.AccountDao;
import com.sdm.pojo.Dog;
import org.springframework.stereotype.Repository;

/**
 * Author: tyza66
 * Date: 2023/6/20 13:08
 * Github: https://github.com/tyza66
 **/

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public Dog getDog() {
        System.out.println("修沟");
        return new Dog("gg",10);
    }
}
