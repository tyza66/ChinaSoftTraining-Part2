package com.sdm;

import com.sdm.mapper.DeptMapper;
import com.sdm.mapper.EmpMapper;
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
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        System.out.println(mapper.selectAllDepts());
    }

    @Test
    public void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder加载配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象 自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获得mapper对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        System.out.println(mapper.selectAllEmps());
    }

    @Test
    public void test3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder加载配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象 自动提交'
        //这个sqlSession有缓存的作用 就是两次查询一样的东西的时候就会直接从缓存里拿而不是再次查找
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.clearCache();//可可以清除缓存
        //获得mapper对象
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //在延迟状态下 如果值要员工的信息 那么只会执行第一个查询语句
        System.out.println(mapper.selectEmpStepOne("tom"));
        //如果获取部门名称 才会执行关联查询语句

        //如果使用了二级缓存 是针对于mapper进行操作的多个session也可以使用
        sqlSession.close();
        resourceAsStream.close();
    }
}
