package com.djh.demo.MyTomcat;

/**
 * @Author: dujunhua
 * @Create: 2021/02/22 15:00
 * @Description:
 */
public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception{
        response.write("get tomcat");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception{
        response.write("post tomcat");
    }
}
