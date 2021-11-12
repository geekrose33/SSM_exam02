package com.geekrose.dao;

import com.geekrose.domain.City_Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Joker_Dong
 * @date 2021-11-10 14:47
 */

public interface CityCRUD {

    // 增
    Integer insertCity(City_Exam city);


    // 删
    Integer delete(@Param(value = "cid") Integer id);


    // 查
    List<City_Exam> select(City_Exam city);



    // 改
    Integer update(City_Exam city_exam);

}
