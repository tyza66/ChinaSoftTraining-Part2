package com.icss;

import com.icss.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestDeptMapper {

    @Test
    public void testDept() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
//        mapper.selectAllDepts().forEach(tmp-> System.out.println(tmp));
        mapper.selectDeptAndEmps().forEach(dept-> System.out.println(dept));
        sqlSession.close();
        inputStream.close();
    }
}
