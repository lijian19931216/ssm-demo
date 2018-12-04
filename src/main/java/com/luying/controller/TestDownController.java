package com.luying.controller;

import com.luying.practice.AliyunUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: lijian
 * @create: 2018-11-03
 **/
@Controller
public class TestDownController {
    @RequestMapping("/testdownload")
    public void testDownload(HttpServletResponse response,  String fileName){
        try {
            AliyunUtil.testDown(fileName, response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
