package com.sdm.mapper;

import com.sdm.pojo.Student;

/**
 * Author: tyza66
 * Date: 2023/6/26 14:57
 * Github: https://github.com/tyza66
 **/

public interface StudentMapper {
    //利用学号查询单个学生的信息
    Student selectStudentById(int sid);
}
