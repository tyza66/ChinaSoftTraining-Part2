package com.sdm;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: tyza66
 * Date: 2023/6/28 10:57
 * Github: https://github.com/tyza66
 **/

public class TestDeptMapper {
    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder加载配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得mapper对象

    }
}
