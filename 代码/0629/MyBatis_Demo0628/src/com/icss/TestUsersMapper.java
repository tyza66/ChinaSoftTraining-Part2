package com.icss;

import com.icss.mapper.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestUsersMapper {

    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        System.out.println(mapper.selectUserAndRoles("tom"));

        sqlSession.close();
        inputStream.close();
    }
}
