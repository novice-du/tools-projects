package com.djh.demo.Controller;

import com.djh.demo.Entity.Apple;
import com.djh.demo.Until.FruitInfoUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("test")
public class TestController {
    //    @CrossOrigin(value = "http://localhost:8081")
    @GET
    @Path("/corsMethod")
//    @ResponseBody()
    public String corsMethod() {
        return "hello";
    }

    @GET
    @Path("/testAOP")
    @Produces(MediaType.APPLICATION_JSON)
    public String testAOP() {
        System.out.println("方法执行");
        System.out.println("第二次方法执行");
        return "success";
    }

    @Path("/upload")
    public String uploading() {
        return "file";
    }

    @GET
    @Path("/fruit")
    public void fruit(){
        FruitInfoUtil.getFruitInfo(Apple.class);
    }

    @GET
    @Path("/loginPage")
    @Produces(MediaType.APPLICATION_JSON)
    public String login(@RequestParam("username")String username, @RequestParam("pwd")String pwd){
        System.out.println("开始执行Controller的方法");
        return "success";
    }

    @GET
    @Path("/sel")
    @Produces(MediaType.APPLICATION_JSON)
    public String sel(){
        System.out.println("开始执行Controller的方法");
        return "success";
    }
}
