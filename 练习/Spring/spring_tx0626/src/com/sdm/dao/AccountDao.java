package com.sdm.dao;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:12
 * Github: https://github.com/tyza66
 **/

public interface AccountDao {
    //实现转账功能

    boolean reduceMoney(String id, double money);

    boolean addMoney(String id, double money);

}
