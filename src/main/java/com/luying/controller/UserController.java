package com.luying.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Controller  
public class UserController {
	private static Logger log=LoggerFactory.getLogger(UserController.class);
    @ResponseBody
    @RequestMapping("/hello")
	public Map hh(){
        Map map=new HashMap();
        map.put("zhangsan", "您好");
        return map;
    }
    @ResponseBody
    @RequestMapping("/hello1")
    public String hh1(){

        return "您好";
    }
    @RequestMapping("/hello2")
    public String hh2(){

        return "index";
    }
}