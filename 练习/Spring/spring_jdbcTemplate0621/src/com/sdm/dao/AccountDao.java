package com.sdm.dao;

import com.sdm.pojo.Account;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/21 10:46
 * Github: https://github.com/tyza66
 **/

public interface AccountDao {
    boolean insertAccount(Account account);

    boolean deleteAccountByID(int aid);

    boolean updateAccount(Account account);

    Account selectAccountByID(int aid);

    List<Account> selectAllAccount();
}
