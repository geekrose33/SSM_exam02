package com.geekrose.dao;

import com.geekrose.vo.StudentAndCity;

import java.util.List;
import java.util.Map;

public interface MultiTable {


    // 查询 学生名称和城市名称
    List<Map<String,Object>> selectBothName();

    // 查询 学生和城市的全部信息
    List<StudentAndCity> selectAll();

    // 查询所有学生年龄小于20 的学生和城市信息
    List<StudentAndCity> selectAge(Integer age);

}
