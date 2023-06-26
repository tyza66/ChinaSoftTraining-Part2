package com.sdm;

import com.sdm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: tyza66
 * Date: 2023/6/26 15:18
 * Github: https://github.com/tyza66
 **/

public class TestStudent {
    @Test
    public void testSelectStudentById() throws IOException {
        //1.创建SqlSessionFactoryBuilder对象
        //2.加载SqlMapConfig.xml配置文件
        //3.创建SqlSessionFactory对象
        //4.创建SqlSession对象
        //5.调用selectOne方法执行查询操作
        //6.打印输出结果
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = (Student) sqlSession.selectOne("com.sdm.mapper.StudentMapper.selectStudentById", 1);//第二个参数是查询条件
        System.out.println(student);
    }
}
