package com.sdm.dao.impl;

import com.sdm.pojo.Customer;
import com.sdm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/6 18:12
 * Github: https://github.com/tyza66
 **/

public class BaseDao {

    public List<Customer> query(String sql, Connection conn,Object...args){
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customer> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(rs,ps,conn);
        }

        return list;
    }
}
