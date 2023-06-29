package com.icss.mapper;

import com.icss.pojo.Dept;

import java.util.List;

public interface DeptMapper {
    List<Dept> selectAllDepts();

    List<Dept> selectDeptAndEmps();

//   分步查询 第二步
    Dept selectDeptByDid(int did);
}
