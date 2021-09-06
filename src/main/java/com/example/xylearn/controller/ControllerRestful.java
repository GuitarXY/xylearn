package com.example.xylearn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller
@RequestMapping("/xiaoyao")
public class ControllerRestful {

//    @Override
//    public ModelAndView handleRequest(HttpServletRequest arg0,
//                                      HttpServletResponse arg1) throws Exception {
//        System.out.println("处理hello.form请求");
//        ModelAndView mv = new ModelAndView("hello");
//        return mv;
//    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> queryUserById(@PathVariable("id") Long id) {
        System.out.println(id);
        return new ResponseEntity<>("www.baidu.com",HttpStatus.MOVED_PERMANENTLY);

    }
}

