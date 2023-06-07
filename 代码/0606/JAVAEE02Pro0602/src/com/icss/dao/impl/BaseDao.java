package com.icss.dao.impl;

import com.icss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
//    增删改
    public boolean exeUpdate(Connection con,String sql,Object...args){
        PreparedStatement pst = null;
        int num = 0;
        try {
            pst = con.prepareStatement(sql);
//            设置参数
            for(int i = 0; i < args.length; i++ ){
                pst.setObject(i + 1,args[i]);
            }

            num  = pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(pst,con);
        }
        return num > 0 ? true : false;
    }

//    查询
    public ResultSet exeQuery(Connection con,String sql,Object...args){
        PreparedStatement pst = null;
        ResultSet rst = null;
        try {
            pst = con.prepareStatement(sql);

            //            设置参数
            for(int i = 0; i < args.length; i++ ){
                pst.setObject(i + 1,args[i]);
            }

            rst = pst.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rst;
    }

}
