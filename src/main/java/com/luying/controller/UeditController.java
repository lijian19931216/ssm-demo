package com.luying.controller;

import com.luying.baidu.ueditor.ActionEnter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description:
 * @author: lijian
 * @create: 2018-12-04
 **/
@Controller
public class UeditController {
    @RequestMapping("/upload")
    public void imgUploadByUeditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        ServletContext application=request.getServletContext();
        String rootPath = application.getRealPath( "/" );
        PrintWriter out = response.getWriter();
        out.write( new ActionEnter( request, rootPath ).exec() );
    }

}
