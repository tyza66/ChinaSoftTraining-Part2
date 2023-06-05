package com.icss.dao.impl;

import com.icss.dao.ICustomerDao;
import com.icss.pojo.Customer;
import com.icss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
//        1 获取连接
        Connection connection = DBUtil.getConnection();
//        2 准备sql 创建PreparedStatement对象 预编译处理
        String sql = "select * from customer where cname = ? and cpwd = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Customer c = null;
        try {
             pst = connection.prepareStatement(sql);
 //        3 设置参数
            pst.setString(1,cname);
            pst.setString(2,cpwd);
//        4 执行sql语句
            rst = pst.executeQuery();
//        5 获取结果并返回
            if (rst.next()) {
                c = new Customer();
                c.setCid(rst.getInt("cid"));
                c.setCname(rst.getString("cname"));
                c.setCpwd(rst.getString("cpwd"));
                c.setCage(rst.getInt("cage"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //        6 关闭数据库
            DBUtil.close(rst,pst,connection);
        }

        return c;
    }
}
