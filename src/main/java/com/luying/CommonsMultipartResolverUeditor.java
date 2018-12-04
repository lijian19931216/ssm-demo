package com.luying;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: lijian
 * @create: 2018-12-04
 **/
public class CommonsMultipartResolverUeditor extends CommonsMultipartResolver {
    @Override
    public boolean isMultipart(HttpServletRequest request)
    {
        String url = request.getRequestURI();
        //对所有请求的上传路径做个匹配，如果是编辑器的请求那么不用springmvc的上传处理
        if (url != null && url.contains("/upload"))
        {
            return false;
        }
        else
        {
            //springmvc的上传处理
            return super.isMultipart(request);
        }
    }
}
