package com.sdm.mapper;

import com.sdm.pojo.Dept;
import com.sdm.pojo.Emp;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/28 12:48
 * Github: https://github.com/tyza66
 **/

public interface EmpMapper {
    List<Emp> selectAllEmps();

    //分步查询
    //根据员工的名字进行查询部门编号 需要提示员工的所有信息
    Emp selectEmpStepOne(String ename);



}
