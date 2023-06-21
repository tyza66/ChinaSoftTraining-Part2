package com.icss.service.impl;

import com.icss.dao.IAccountDao;
import com.icss.dao.impl.AccountDaoImpl;
import com.icss.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService {

//    创建dao实例化对象
//     @Autowired 自动注入 属性赋值 默认按照类型注入  按照名字注入(属性名称和注解value名称一致)
//    如果以上条件均不满足 添加@Qualifier(value = "bean中id名称")

//     javax 注解 @Resource(name = "bean中id名称")
    /*@Autowired
    @Qualifier(value = "accountDao2")*/
    @Resource(name = "accountDao1")
    IAccountDao accountDao;

    @Override
    public void selectAccountDao() {
        accountDao.selectAccountDao();
    }


}
