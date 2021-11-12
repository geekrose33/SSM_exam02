package com.geekrose.controller;

import com.geekrose.domain.City_Exam;
import com.geekrose.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Joker_Dong
 * @date 2021-11-10 14:48
 */
@Controller
@RequestMapping("/city")
public class MyController {

    @Resource
    private CityService service;


    @RequestMapping("/insert.do")
    public ModelAndView doInsert(String cid, String cname, String pid){
        Integer icid = null;
        Integer ipid = null;

        if (cid != null){
            icid = Integer.valueOf(cid);
        }

        if (pid != null){
            ipid = Integer.valueOf(pid);
        }

        ModelAndView mv = new ModelAndView();

        Integer integer = service.insertCity(new City_Exam(icid, cname, ipid));
        if (integer == null){
            mv.addObject("msg","添加失败");
            mv.setViewName("insert");
        }else {
            mv.addObject("msg","添加成功");
            mv.setViewName("insert");
        }
        return mv;

    }

    /*@RequestMapping("/select.do")
    public @ResponseBody List<City_Exam> doSelect(String cid,String cname,String pid){
        System.out.println("cid:"+cid);
        System.out.println("cname:"+cname);
        System.out.println("pid:"+pid);
        Integer icid = null;
        Integer ipid = null;
        if (cid != null){
            icid = Integer.valueOf(cid);
        }
        if (pid != null){
            ipid = Integer.valueOf(pid);
        }
        City_Exam city = new City_Exam(icid,cname,ipid);

        List<City_Exam> list = service.select(city);

        return list;

    }*/

    @RequestMapping("/select.do")
    public @ResponseBody List<City_Exam> doSelect(City_Exam city){

        List<City_Exam> list = service.select(city);

        return list;

    }

    @RequestMapping("/delete.do")
    public @ResponseBody List<City_Exam> doDelete(HttpServletRequest request, HttpServletResponse response, String cid){
        Integer id = Integer.valueOf(cid);
        Integer i = service.delete(id);
        List<City_Exam> list = null;
        if (i == 1){
            list = doSelect(new City_Exam());
        }
        return list;
    }


    @RequestMapping("/update.do")
    public ModelAndView doUpdate(@RequestParam(value = "cid") String cid , String cname, String pid){
        ModelAndView mv = new ModelAndView();
        Integer icid = null;
        Integer ipid = null;
        if (cid != null){
            icid = Integer.valueOf(cid);
        }
        if (pid != null){
            ipid = Integer.valueOf(pid);
        }


        Integer i = service.update(new City_Exam(icid,cname,ipid));
        if (i == 1){
            mv.addObject("msg","修改成功");
            mv.setViewName("update");
        }else {
            mv.addObject("msg","修改失败");
            mv.setViewName("update");
        }

        return mv;
    }

}
