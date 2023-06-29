package com.icss;

import com.icss.mapper.EmpMapper;
import com.icss.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestEmpMapper {

    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sessionFactory.openSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
//        mapper.selectAllEmps().forEach(emp-> System.out.println(emp));
        Emp emp = mapper.selectEmpStepOne("tom");
//        在延迟加载状态下 如果只要员工的信息 那么只会执行select * from emp e where e.ENAME = ?
        System.out.println("emp名字 " + emp.getEname());
//        如果获取部门名称 才会执行关联查询语句 select * from dept where did = ?
        System.out.println("emp部门名称 " + emp.getDept().getDeptname());

        sqlSession.close();
        inputStream.close();
    }
}
