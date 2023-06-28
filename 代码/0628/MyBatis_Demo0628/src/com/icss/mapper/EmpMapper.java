package com.icss.mapper;

import com.icss.pojo.Emp;

import java.util.List;

public interface EmpMapper {
//    查询所有的员工(包括员工所在部门名称) 有的员工没有部门 外连接
    List<Emp> selectAllEmps();
}
