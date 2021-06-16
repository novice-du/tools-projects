package com.djh.demo.Service.ServiceImpl;


import com.djh.demo.Dao.UserDao;
import com.djh.demo.Entity.User;
import com.djh.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        System.out.println("进入Serviceimpl");
        return userDao.findAll();
    }

    @Override
    public List<User> selectStudentByGradeAndClass(Map<String, String> map) {
        try {
            System.out.println("进入ServiceImpl" + map);
            List<User> list = userDao.selectStudentByGradeAndClass(map);
            System.out.println("查出结果集：  " + list);
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询有异常");
        }
        return null;
    }

    @Override
    public List<User> selectStudentById(List<Integer> list) {
        List<User> list1 = userDao.selectStudentById(list);
        return list1;
    }

    @Override
    public int deleteFromProcedure(int tid) {
        int i = userDao.deleteFromProcedure(tid);
        if (i > 0) {
            return 1;
        }
        return 0;
    }
}
