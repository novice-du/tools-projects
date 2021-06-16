package com.djh.demo.Controller;

import com.djh.demo.Entity.User;
import com.djh.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController    //该注解=@Controller和方法上的@Responsebody
//@RequestMapping("/user")
@Path("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserService userService;

    //@RequestMapping("/findAll")
    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> findAll() {

        System.out.println("进入controller");
        //事先使用 if (logger.isInfoEnabled())进行判断，那么当log级别在INFO以上时，
        //就能省去字符串操作，在高并发和复杂log信息拼接的情况下，使用这种标准的方法输出log能够省去不小的系统开销。
        if (logger.isInfoEnabled()){
            logger.info("info");
        }
        logger.debug("debug");   //日志级别设置的为info，所以debug<info，所以不会打印
        logger.warn("warn");
        logger.error("error");
        return userService.findAll();
    }

    @GET
    @Path("/selectStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> addStudent(@QueryParam("grade") String grade, @QueryParam("nameOfClass") String nameOfClass) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("grade", grade);
        map.put("nameOfClass", nameOfClass);
        System.out.println("进入Controller=====" + map);
        List<User> list = userService.selectStudentByGradeAndClass(map);
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @GET
    @Path("/selectStudent/{id}/{id2}/{id3}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> selectStudentById(@PathParam("id") int id,
                                        @PathParam("id2") int id2,
                                        @PathParam("id3") int id3) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(id);
        list.add(id2);
        list.add(id3);
        List<User> listUser = userService.selectStudentById(list);
        return listUser;
    }

    @DELETE
    @Path("/delFromPrp/{tid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String delFromProcedure(@PathParam("tid") int tid) {
        int i = userService.deleteFromProcedure(tid);
        if (i > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

}
