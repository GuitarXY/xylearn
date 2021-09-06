package com.example.xylearn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

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
    public ModelAndView execute1() throws Exception{
        String url = "redirect:http://www.baidu.com";
        return new ModelAndView(url);

    }
    @RequestMapping("/hello2")
    public void execute2(HttpServletResponse response) throws Exception{
        String url = "http://www.baidu.com";
        response.setStatus(301);
        //response.sendRedirect();
        response.setHeader("Location","www.baidu.com");

    }
    @RequestMapping("/hello")
    public String execute(HttpServletResponse response) throws Exception{
        response.sendRedirect("www.baidu.com");
        return "www.baidu.com";
    }

}

