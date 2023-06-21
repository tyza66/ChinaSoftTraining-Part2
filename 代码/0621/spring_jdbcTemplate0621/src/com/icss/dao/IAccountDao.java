package com.icss.dao;

import com.icss.pojo.Account;

import java.util.List;

public interface IAccountDao {

    boolean insertAccount(Account account);

    boolean deleteAccountById(int aid);

    boolean updateAccountById(Account account);

    Account selectAccountById(int aid);

    List<Account> selectAllAccount();
}
