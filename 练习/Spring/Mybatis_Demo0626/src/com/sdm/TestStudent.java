package com.sdm;

import com.sdm.mapper.StudentMapper;
import com.sdm.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        //5.调用selectOne方法执行查询操作或用其他方式调用方法执行增删改操作
        //6.打印输出结果

        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //使用SqlSessionFactoryBuilder加载配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //方式1 调用会话中已有的方法进行查询
        Student student = (Student) sqlSession.selectOne("com.sdm.mapper.StudentMapper.selectStudentById", 1);//第二个参数是查询条件
        System.out.println(student);

        //方式2 利用mapper接口进行查询
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //查询
        Student student1 = mapper.selectStudentById(1);
        System.out.println(student1);

        //插入
//        boolean b = mapper.insertStudent(new Student(40, "李四", "男", "北京"));
//        System.out.println(b);
//
//        //更新
//        boolean b1 = mapper.updateStudentById(new Student(40, "李四", "男", "天京"));
//        System.out.println(b1);

        //删除
        //boolean b2 = mapper.deleteStudentById(40);

        //查询所有
        List<Student> students = mapper.selectAllStudent();
        System.out.println(students);

        //        提交
//        给定一个布尔值为true 自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        调用commit方法提交
        sqlSession.commit();
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
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectStudentByNameAndCity("tom", "大连");
        System.out.println(students);

        List<Student> students1 = mapper.selectStudentByNameLike("o");
        System.out.println(students1);

        List<Student> students2 = mapper.selectAllStudentOrderByColumn("sid");
        System.out.println(students2);

        boolean b = mapper.deleteStudentByIds("1,2");
        System.out.println(b);

        List<Student> students3 = mapper.selectStudentByPage(0, 2);
        System.out.println(students3);

        int i = mapper.selectCount();
        System.out.println(i);

        //弄完之后这个sid会自动赋值给student对象
        Student student = new Student("giao", "男", "大连");
        int primaryKeySid = mapper.getPrimaryKeySid(student);
        System.out.println(primaryKeySid);
        System.out.println("插入的sid"+student.getSid());

        List<Student> students4 = mapper.selectStudentByNameOrGen("tom", "男");
        System.out.println(students4);
    }
}
