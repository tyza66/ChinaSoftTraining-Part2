package com.icss.dao.impl;

import com.icss.dao.ICustomerDao;
import com.icss.pojo.Customer;
import com.icss.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements ICustomerDao {

    @Override
    public Customer selectCusByNameAndPwd(String cname, String cpwd) {
//        1 获取连接
        Connection connection = DBUtil.getConnection();
//        2 准备sql 创建PreparedStatement对象 预编译处理
        String sql = "select * from \"customer\" where \"cname\" = ? and \"cpwd\" = ?";
        PreparedStatement pst = null;
        ResultSet rst = null;
        Customer c = null;
        System.out.println(1);
        try {
            pst = connection.prepareStatement(sql);
            System.out.println(2);
            //        3 设置参数
            pst.setString(1, cname);
            pst.setString(2, cpwd);
//        4 执行sql语句
            rst = pst.executeQuery();
            System.out.println(3);
//        5 获取结果并返回
            if (rst.next()) {
                System.out.println(4);
                c = new Customer();
                c.setCid(rst.getInt(1));
                c.setCname(rst.getString(2));
                c.setCpwd(rst.getString(3));
                c.setCage(rst.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //        6 关闭数据库
            DBUtil.close(rst, pst, connection);
        }

        return c;
    }

    @Override
    public Customer selectCusByCname(String cname) {
//        获取数据库连接
        Connection connection = DBUtil.getConnection();
//        2 sql
        String sql = "select * from \"customer\" where \"cname\" = ?";
//        3 创建预编译对象 预编译处理
        PreparedStatement pst = null;
        Customer c = null;
        ResultSet rst = null;
        try {
            pst = connection.prepareStatement(sql);
//            4 设置参数
            pst.setString(1, cname);

            rst = pst.executeQuery();

            if (rst.next()) {
                c = new Customer();
                c.setCid(rst.getInt(1));
                c.setCname(rst.getString(2));
                c.setCpwd(rst.getString(3));
                c.setCage(rst.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean insertCus(Customer cus) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into \"customer\" values(\"cus_seq\".nextval,?,?,?)";
        PreparedStatement pst = null;
        int i = 0;
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, cus.getCname());
            pst.setString(2, cus.getCpwd());
            pst.setString(3, cus.getCage());

            i = pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return i > 0 ? true : false;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from \"customer\"";
        ResultSet rst = null;
        List<Customer> list = new ArrayList<>();
        try {
            rst = exeQuery(connection, sql);

            while (rst.next()) {
                Customer c = new Customer();
                c.setCid(rst.getInt(1));
                c.setCname(rst.getString(2));
                c.setCpwd(rst.getString(3));
                c.setCage(rst.getString(4));

                list.add(c);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }


        return list;
    }

    @Override
    public boolean deleteCusById(int cid) {
        return exeUpdate(DBUtil.getConnection(), "delete from \"customer\" where \"id\" = ?", cid);
    }

    @Override
    public boolean deleteCusById(Connection connection, int cid) {
        return exeUpdate(connection, "delete from \"customer\" where \"id\" = ?", cid);
    }

    @Override
    public int getCueCount() {
        ResultSet resultSet = exeQuery(DBUtil.getConnection(), "select count(*) from \"customer\"");
        int count = 0;
        try {
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    @Override
    public List<Customer> selectCuesByPage(int start, int end) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from (select rownum r, c.* from \"customer\" c) c1 where c1.r BETWEEN ? and ?";
        List<Customer> list = new ArrayList<>();
        ResultSet rst = null;
        try {
            rst = exeQuery(connection,sql,start,end);

            while(rst.next()){
                Customer c = new Customer();
                c.setCid(rst.getInt(2));
                c.setCname(rst.getString(3));
                c.setCpwd(rst.getString(4));
                c.setCage(rst.getString(5));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Customer selectCusById(int cid) {
        Connection con = DBUtil.getConnection();
        ResultSet rst = exeQuery(con, "select * from \"customer\" where \"id\" = ?", cid);
        Customer c = null;
        try {
            if (rst.next()) {
                c = new Customer();
                c.setCid(rst.getInt(1));
                c.setCname(rst.getString(2));
                c.setCpwd(rst.getString(3));
                c.setCage(rst.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return c;
    }

    @Override
    public boolean updateCusById(Customer customer) {
        return exeUpdate(DBUtil.getConnection(), "update \"customer\" set \"cname\" = ?,\"cpwd\" = ?,\"cage\" = ? where \"id\" = ?",
                customer.getCname(), customer.getCpwd(), customer.getCage(), customer.getCid());
    }

    @Override
    public int getCount() {
        ResultSet rst = exeQuery(DBUtil.getConnection(), "select * from visitCount");
        int num = 0;
        try {
            if (rst.next()) {
                num = rst.getInt("count");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }

    @Override
    public boolean updateCount(int count) {
        return exeTransitionUpdate(DBUtil.getConnection(), "update visitcount set count = ?", count);
    }

    @Override
    public List<Customer> selectCusByNameAndAge(String cname, String cage, int start, int end) {
        Connection connection = DBUtil.getConnection();

//        StringBuffer stringBuffer = new StringBuffer("select c1.* from (select rownum r, c.* from customer c) c1  where 1 = 1 ");

        ResultSet rst = null;
        List<Customer> list = new ArrayList<>();
        String sql = "";

        if (cname != null && cname != "" && cage != null && cage != "") {
            sql = "select c1.* from (select rownum r, c.* from \"customer\" c where \"cname\" like ? and \"cage\" = ?) c1 where c1.r BETWEEN ? and ? ";
            rst = exeQuery(connection,sql,cname,cage,start,end);

        }else if (cname != null && cname != "") {
            sql = "select c1.* from (select rownum r, c.* from \"customer\" c where \"cname\" like ?) c1 where c1.r BETWEEN ? and ? ";
            rst = exeQuery(connection,sql,cname,start,end);

        } else if (cage != null && cage != "") {

            sql = "select c1.* from (select rownum r, c.* from \"customer\" c where \"cage\" = ?) c1 where c1.r BETWEEN ? and ? ";
            rst = exeQuery(connection,sql,cage,start,end);
        } else {
            sql = "select c1.* from (select rownum r, c.* from \"customer\" c ) c1 where c1.r BETWEEN ? and ? ";
            rst = exeQuery(connection,sql,start,end);
        }

        try {
            while(rst.next()){
                Customer c = new Customer();
                c.setCid(rst.getInt(2));
                c.setCname(rst.getString(3));
                c.setCpwd(rst.getString(4));
                c.setCage(rst.getString(5));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public int getCusByNameAndAgeCount(String cname, String cage) {
        Connection connection = DBUtil.getConnection();
        StringBuffer stringBuffer = new StringBuffer("select count(*) from \"customer\" where 1 = 1 ");

        ResultSet rst = null;
        int num = 0;

        if (cname != null && cname != "" && cage != null && cage != "") {
            stringBuffer.append("and \"cname\" like ? and \"cage\" = ?");
            rst = exeQuery(connection,stringBuffer.toString(),cname,cage);
        } else if (cname != null && cname != "" ) {
            stringBuffer.append("and \"cname\" like ?");
            rst = exeQuery(connection,stringBuffer.toString(),cname);
        } else if (cage != null && cage != "") {
            stringBuffer.append("and \"cage\" = ?");
            rst = exeQuery(connection,stringBuffer.toString(),cage);
        } else {
            rst = exeQuery(connection,stringBuffer.toString());
        }

        try {
            if (rst.next()) {
                num = rst.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return num;
    }
}
