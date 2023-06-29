package com.sdm.mapper;

import com.sdm.pojo.Dept;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/28 10:46
 * Github: https://github.com/tyza66
 **/

public interface DeptMapper {
    List<Dept> selectAllDepts();

    List<Dept> selectAllDeptsWithEmps();

    //分步查询的第二步 根据部门编号进行查询部门信息
    Dept selectDeptByDid(int did);
}
