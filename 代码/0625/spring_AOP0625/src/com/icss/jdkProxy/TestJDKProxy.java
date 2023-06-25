package com.icss.jdkProxy;

public class TestJDKProxy {
    public static void main(String[] args) {
//        jdk代理对象
        JDKProxy jdkProxy = new JDKProxy();
//         目标对象
        IUserDao userDao = new UserDaoImpl();

//        将目标对象传入 获取代理对象
        IUserDao iUserDao = (IUserDao) jdkProxy.createProxy(userDao);

//        通过代理对象调用目标方法 invoke() 实现动态增强效果
        iUserDao.addUser();

        iUserDao.deleteUser();
    }
}
