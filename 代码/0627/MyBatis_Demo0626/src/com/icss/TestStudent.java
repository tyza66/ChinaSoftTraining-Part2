package com.icss;

import com.icss.mapper.IStudentMapper;
import com.icss.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestStudent {

    @Test
    public void test1() throws IOException {
//        加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        构建SqlSessionFactory 会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        方式一：调用会话中已有的方法完成功能selectOne
        Student student = (Student) sqlSession.selectOne("com.icss.mapper.IStudentMapper.selectStudentBySId", 1);

        System.out.println("student " + student);

//        方式二 sqlSession.getMapper(IStudentMapper.class); 获取接口
        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);
        /*Student student1 = mapper.selectStudentBySId(1);
        System.out.println("通过获取接口" + student1);*/

//        测试插入
        /*boolean b = mapper.insertStudent(new Student("小明", "男", "大连"));
        System.out.println("执行插入信息返回值 " + b);*/

//        System.out.println("删除学生信息" + mapper.deleteStudentBySid(4));

        System.out.println("更新学生信息 " + mapper.updateStudentBySid(new Student(1,"小红","女","锦州")));


        List<Student> students = mapper.selectAllStudents();
        students.forEach((tmp)->{
            System.out.println(tmp);
        });

//        提交
//        给定一个布尔值为true 自动提交
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        调用commit方法提交
//        sqlSession.commit();

    }

    @Test
    public void test2() throws IOException {
        //        加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        构建SqlSessionFactory 会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);

//        List<Student> list = mapper.selectStuByNameAndCity("小红", "锦州");

//        List<Student> list = mapper.selectStuByLikeName("%" + "r" + "%");
//        List<Student> list = mapper.selectStuByLikeName("r");

//        List<Student> list = mapper.selectAllStuOrderCol("sid");

        System.out.println("批量删除 " + mapper.deleteMoreStu("1,2"));

//        List<Student> list = mapper.selectAllStudents();
        List<Student> list = mapper.selectStuByPage(0,5);
        System.out.println("一个有多个个学生 " + mapper.getStuCount());

        Student student = new Student("小强", "男", "大连");

        int num = mapper.getPrimaryKeySid(student);
        
        System.out.println("返回影响的行数num " + num);
        System.out.println("获取主键的值 " + student.getSid());

        list.forEach(tmp->{
            System.out.println(tmp);
        });
    }


    @Test
    public void test3() throws IOException {
        //        加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
//        构建SqlSessionFactory 会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        IStudentMapper mapper = sqlSession.getMapper(IStudentMapper.class);

//        select * from student where 1 = 1
//        List<Student> list  = mapper.selectStuByNameOrGen(null,null);
//        select * from student where 1 = 1 and sname like "%"?"%"
//        List<Student> list  = mapper.selectStuByNameOrGen("小",null);
//      select * from student where 1 = 1 and gender = ?
//        List<Student> list  = mapper.selectStuByNameOrGen("","男");
//        select * from student where 1 = 1 and sname like "%"?"%" and gender = ?
//        List<Student> list  = mapper.selectStuByNameOrGen("小","男");

        List<Student> list  = mapper.selectChoseStudent("小","大");
        list.forEach(tmp->{
            System.out.println(tmp);
        });
    }
}
