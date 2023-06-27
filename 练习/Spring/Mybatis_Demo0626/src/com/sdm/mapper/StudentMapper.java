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

}
