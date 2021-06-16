package com.djh.demo.MyTomcat;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: dujunhua
 * @Create: 2021/02/22 14:10
 * @Description:
 */
public class MyRequest {

    //请求方法
    private String requestMethod;
    //请求地址
    private String requestUrl;

    public MyRequest(InputStream inputStream) throws IOException {
        //缓冲区域
        byte[] buffer = new byte[1024];
        //读取数据的长度
        int len = 0;
        //定义请求的变量
        String str = null;
        //读取数据
        if ((len = inputStream.read(buffer)) > 0){
            str = new String(buffer,0,len);
        }
        //按换行切割
        //GET / HTTP/1.1
        String data = str.split("\n")[0];
        String[] param = data.split(" ");
        this.requestMethod = param[0];
        this.requestUrl = param[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
