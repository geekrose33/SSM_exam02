package com.geekrose.service;

import com.geekrose.dao.CityCRUD;
import com.geekrose.domain.City_Exam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Joker_Dong
 * @date 2021-11-10 15:33
 */
@Service
public class CityService {

    @Resource
    private CityCRUD cityCRUD;

    public Integer insertCity(City_Exam city) {
        Integer integer = null;
        if (city != null){
            integer = cityCRUD.insertCity(city);
        }

        return integer;

    }

    public List<City_Exam> select(City_Exam city) {
        List<City_Exam> list = cityCRUD.select(city);
        return list;
    }

    public Integer delete(Integer cid) {

        Integer i = cityCRUD.delete(cid);
        return i;
    }

    public Integer update(City_Exam city_exam) {
        Integer i = cityCRUD.update(city_exam);
        return i;
    }
}
