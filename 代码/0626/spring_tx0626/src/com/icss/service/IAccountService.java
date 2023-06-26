package com.icss.service;

/**
 * 业务逻辑处理
 */
public interface IAccountService {
//    转账
    boolean transferAccount(String fromName,String toName,double money);
}
