package com.luying.practice;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.luying.utils.PropertiesUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: lijian
 * @create: 2018-11-03
 **/
interface Constant {
    String ENDPOINT = "ENDPOINT";
    String ACCESSKEYID = "ACCESSKEYID";
    String ACCESSKEYSECRET = "ACCESSKEYSECRET";
    String BUCKETNAME = "BUCKETNAME";
}
public class AliyunUtil{
    private static final String endpoint=PropertiesUtil.getString(Constant.ENDPOINT);
    private static final String accesskeyid=PropertiesUtil.getString(Constant.ACCESSKEYID);
    private static final String accesskeysecret=PropertiesUtil.getString(Constant.ACCESSKEYSECRET);
    private static final String bucketname=PropertiesUtil.getString(Constant.BUCKETNAME);
    private static Logger log = LoggerFactory.getLogger(AliyunUtil.class);


    public static void testDown(String fileName ,HttpServletResponse response) throws UnsupportedEncodingException {
       /* response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition","attachment;filename=" + new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
*/

        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSClient ossClient = new OSSClient(endpoint, accesskeyid, accesskeysecret);
        OSSObject ossObject = ossClient.getObject(bucketname, fileName);
        try(InputStream inputStream=ossObject.getObjectContent();
            OutputStream os=response.getOutputStream()) {
            IOUtils.copy(inputStream, os);
        }catch (Exception e){
            log.error("预览失败");

            e.printStackTrace();
            log.error("预览失败0----------------------");

            throw new RuntimeException("出异常了0000");

        }
        log.info("---------------------------");
        ossClient.shutdown();
        log.info("=======================");

    }
}