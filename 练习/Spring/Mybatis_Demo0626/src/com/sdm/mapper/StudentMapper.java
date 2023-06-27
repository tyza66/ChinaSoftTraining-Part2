package com.sdm.mapper;

import com.sdm.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/26 14:57
 * Github: https://github.com/tyza66
 **/

public interface StudentMapper {
    //利用学号查询单个学生的信息
    Student selectStudentById(int sid);

    List<Student> selectAllStudent();

    boolean insertStudent(Student student);

    boolean deleteStudentById(int sid);

    boolean updateStudentById(Student student);

    //根据名字和城市进行查询
    List<Student> selectStudentByNameAndCity(@Param("name") String name,@Param("city") String city);

    //根据名字进行模糊查询
    List<Student> selectStudentByNameLike(@Param("name") String name);

    //查询所有的学生信息 并启用指定的字段名称进行排序
    List<Student> selectAllStudentOrderByColumn(@Param("column") String column);

    //指定多个学号批量删除
    boolean deleteStudentByIds(@Param("sids") String sids);

    //分页查询
    List<Student> selectStudentByPage(@Param("start") int start,@Param("pageSize") int pageSize);

    //查询表中所有的记录数
    int selectCount();

    //获取增加学生后主键的值
    int getPrimaryKeySid(Student student);

    //用动态的sql语句完成
    List<Student> selectStudentByNameOrGen(@Param("name") String name,@Param("gender") String gender);
}
