package com.sdm.dao.impl;

import com.sdm.dao.ICustomerDao;
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
 * Date: 2023/6/5 10:58
 * Github: https://github.com/tyza66
 **/

public class CustomerDaoImpl implements ICustomerDao {
    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
        //获取链接 准备sql 设置参数 执行
        Connection connection = DBUtil.getConnection();
        String sql = "select * from \"customer\" where \"cname\"= ? and \"cpwd\"= ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cname);
            ps.setString(2, cpwd);
            rs = ps.executeQuery();
            if (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setCname(rs.getString(2));
                customer.setCpwd(rs.getString(3));
                customer.setCage(rs.getString(4));
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, ps, connection);
        }
        return null;
    }

    @Override
    public Boolean insertCus(Customer customer) {
        Connection conn = DBUtil.getConnection();
        String sql = "INSERT INTO \"SCOTT\".\"customer\" VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customer.getId());
            ps.setString(2, customer.getCname());
            ps.setString(3, customer.getCpwd());
            ps.setString(4, customer.getCage());
            int i = ps.executeUpdate();
            if(i>=1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        //获取链接 准备sql 设置参数 执行
        Connection connection = DBUtil.getConnection();
        String sql = "select * from \"customer\"";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customer> list = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                list.add(new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, ps, connection);
        }
        return list;
    }

    @Override
    public Boolean updateCus(Customer customer) {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE \"SCOTT\".\"customer\" SET \"cname\" = ?, \"cpwd\" = ?, \"cage\" = ? WHERE \"id\" = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(4,customer.getId());
            ps.setString(1, customer.getCname());
            ps.setString(2, customer.getCpwd());
            ps.setString(3, customer.getCage());
            int i = ps.executeUpdate();
            if(i>=1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public Boolean deleteCus(int id) {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM \"SCOTT\".\"customer\" WHERE \"id\" = ?";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            if(i>=1){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(ps,conn);
        }
        return false;
    }

    @Override
    public int getVisitorCount() {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from \"visitcount\"";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()){
                int times = rs.getInt(1);
                return times;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(rs, ps, connection);
        }
        return 0;
    }

    @Override
    public int setVisitorCount(int count) {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE \"SCOTT\".\"visitcount\" SET \"times\" = ? WHERE ROWID = 'AAASPCAAEAAAAIbAAA'";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,count);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(ps,conn);
        }
    }

}
