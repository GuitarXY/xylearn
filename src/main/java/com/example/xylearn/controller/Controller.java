package com.example.xylearn.controller;

import com.alibaba.fastjson.JSON;
import com.example.xylearn.dao.UserDao;
import com.example.xylearn.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/xiaoyao")
public class Controller {

    //    @Override
//    public ModelAndView handleRequest(HttpServletRequest arg0,
//                                      HttpServletResponse arg1) throws Exception {
//        System.out.println("处理hello.form请求");
//        ModelAndView mv = new ModelAndView("hello");
//        return mv;
//    }
    @RequestMapping("/hello1")
    public ModelAndView execute1() throws Exception {
        String url = "redirect:http://www.baidu.com";
        return new ModelAndView(url);

    }

    @PostMapping("/urlEncode")
    public String urlEncode(@RequestParam("s") String s) throws Exception {
        System.out.println(s);
        return s;

    }

    @Autowired
    private UserDao userDao;

    @RequestMapping("/hellomybatis")
    public String hellomybatis() throws Exception {
        List<User> all = userDao.findAll();
        System.out.println(JSON.toJSON(all));
        return all.toString();

    }

    @RequestMapping("/hello2")
    public void execute2(HttpServletResponse response) throws Exception {
        String url = "http://www.baidu.com";
        response.setStatus(301);
        //response.sendRedirect();
        response.setHeader("Location", "www.baidu.com");

    }

    @RequestMapping("/hello")
    public String execute(HttpServletResponse response) throws Exception {
        response.sendRedirect("www.baidu.com");
        return "www.baidu.com";
    }

}

