package com.djh.demo.Service;

import com.djh.demo.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    List<User> selectStudentByGradeAndClass(Map<String, String> map);

    List<User> selectStudentById(List<Integer> list);

    //调用存储过程删除数据
    int deleteFromProcedure(int tid);
}
