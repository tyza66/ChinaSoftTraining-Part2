package com.sdm.service;

/**
 * Author: tyza66
 * Date: 2023/6/26 10:21
 * Github: https://github.com/tyza66
 **/

public interface AccountService {
    //业务逻辑处理
    boolean transfer(int fromId, int toId, double money);
}
