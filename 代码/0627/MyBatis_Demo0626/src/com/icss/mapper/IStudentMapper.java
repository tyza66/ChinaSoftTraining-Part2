package com.icss.mapper;

import com.icss.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IStudentMapper {
//    利用学号查询单个学生的信息
    Student selectStudentBySId(int sid);

//    查询所有的学生信息
    List<Student> selectAllStudents();

//    增加学生信息
    boolean insertStudent(Student student);

//    删除学生信息
    boolean deleteStudentBySid(int sid);

//    更新学生信息
    boolean updateStudentBySid(@Param("stu") Student student);

//    多参数查询  根据学生名字和城市进行查询
    List<Student> selectStuByNameAndCity(@Param("name") String name,@Param("scity") String city);

//    模糊查询 根据名字模糊查询
    List<Student> selectStuByLikeName(String name);

//    查找所有的学生信息  按照指定的字段名进行排序  方法参数就是字段名称
    List<Student> selectAllStuOrderCol(String col);

//    批量删除 多个学号
    boolean deleteMoreStu(String sids);

//    分页查询
    List<Student> selectStuByPage(@Param("start") int start, @Param("pageNum") int pageNum);

//    查询表中所有的记录数
    int getStuCount();

//    获取增加学生后主键的值
    int getPrimaryKeySid(Student student);

//    动态sql语句  if标签
    List<Student> selectStuByNameOrGen(@Param("name") String name,@Param("gender") String gender);

//   动态sql语句  choose、when、otherwise标签
    List<Student> selectChoseStudent(@Param("name") String name,@Param("city") String city);

}
