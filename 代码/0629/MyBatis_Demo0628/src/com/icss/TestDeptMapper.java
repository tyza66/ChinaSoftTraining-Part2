package com.icss;

import com.icss.mapper.DeptMapper;
import com.icss.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        MyBatis缓存 一级缓存 SqlSession 默认开启一级缓存 同一个SqlSession 做相同的查询
//        客户端发起请求进行查询 先去缓存中查找
//         如果缓存中没有对应查询数据结果 则去数据库中查询,把查询的结果存入缓存中,最终返回客户端
//         如果缓存中有对应查询数据结果 则直接返回客户端
        SqlSession sqlSession = sessionFactory.openSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
//        Dept dept1 = mapper.selectDeptByDid(1);
        List<Dept> depts = mapper.selectDeptAndEmps();
        System.out.println("第一次查询返回dept1 " + depts);

//        清除缓存  sqlSession.commit()  sqlSession.close()
//        sqlSession.clearCache();
        sqlSession.commit();
        sqlSession.close();

        SqlSession sqlSession2 = sessionFactory.openSession();
        DeptMapper mapper2 = sqlSession2.getMapper(DeptMapper.class);

//        Dept dept2 = mapper2.selectDeptByDid(1);
        List<Dept> depts2 = mapper2.selectDeptAndEmps();
        System.out.println("第一次查询返回dept2 " + depts2);

        sqlSession2.close();
        inputStream.close();

    }
}
