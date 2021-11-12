package com.geekrose;

import com.geekrose.controller.MyController;
import com.geekrose.dao.CityCRUD;
import com.geekrose.dao.MultiTable;
import com.geekrose.domain.City_Exam;
import com.geekrose.service.CityService;
import com.geekrose.vo.StudentAndCity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Joker_Dong
 * @date 2021-11-10 14:59
 */

public class TestMybatis {
    @Test
    public void testDao01() throws IOException {
        String config = "mybatis-config.xml";
        InputStream resource = Resources.getResourceAsStream(config);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = sqlSessionFactory.openSession();

        CityCRUD dao = session.getMapper(CityCRUD.class);
        Integer num = dao.insertCity(new City_Exam(6, "本溪", 1));

        System.out.println("影响了" + num +"行");
        // Mybatis默认手动提交事务
        session.commit();

    }
    @Test
    public void testSpringMybatis01(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");
        CityCRUD cityCRUD = context.getBean("cityCRUD", CityCRUD.class);
        Integer integer = cityCRUD.insertCity(new City_Exam(7, "朝阳", 1));
        System.out.println("影响了" + integer +"行");


    }

    @Test
    public void testDao(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CityCRUD dao = context.getBean("cityCRUD", CityCRUD.class);
        List<City_Exam> list = dao.select(new City_Exam(null,null,null));
        for (City_Exam exam : list) {
            System.out.println(exam);
        }

    }
    @Test
    public void testService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CityService service = context.getBean("cityService", CityService.class);
        List<City_Exam> list = service.select(new City_Exam(null, null, null));
        for (City_Exam exam : list) {
            System.out.println(exam);
        }
    }


    @Test
    public void testController(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyController controller = context.getBean("myController", MyController.class);
        List<City_Exam> list = controller.doSelect(new City_Exam(null,null,null));

        for (City_Exam exam : list) {
            System.out.println(exam);
        }
    }

    @Test
    public void testInt(){
        Integer i = new Integer(10);
        System.out.println(i.getClass());
        String is = "12";
        System.out.println(is.getClass());
        Integer ins = Integer.parseInt(is);
        System.out.println(ins.getClass());
        System.out.println(Integer.parseInt(is) == 12);
    }

    @Test
    public void testDelete(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CityCRUD dao = context.getBean("cityCRUD", CityCRUD.class);
        Integer delete = dao.delete(6);
        System.out.println(delete);
    }

    @Test
    public void testInsert(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyController controller = context.getBean("myController", MyController.class);
        ModelAndView mv = controller.doInsert("6", "本溪", "1");
        System.out.println(mv.getViewName());
        System.out.println(mv.getModel());
    }

    @Test
    public void testSelectBothName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MultiTable dao = context.getBean("multiTable", MultiTable.class);
        List<Map<String, Object>> maps = dao.selectBothName();
        for (Map<String,Object> map:maps){
            Set<String> set = map.keySet();
            for (String key:set){
                System.out.println("key: " + key);
                System.out.println("value: " + map.get(key));
            }


        }
    }

    @Test
    public void testSelectAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MultiTable dao = context.getBean("multiTable", MultiTable.class);
        List<StudentAndCity> studentAndCities = dao.selectAll();
        for (StudentAndCity sac:studentAndCities){
            System.out.println(sac);
        }


    }

    @Test
    public void testSelectAge(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MultiTable dao = context.getBean("multiTable", MultiTable.class);
        List<StudentAndCity> studentAndCities = dao.selectAge(20);
        for (StudentAndCity studentAndCity:studentAndCities){
            System.out.println(studentAndCity);
        }
    }

}
