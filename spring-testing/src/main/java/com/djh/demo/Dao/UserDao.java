package com.djh.demo.Dao;

import com.djh.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
@Mapper
public interface UserDao {
    //查询一年级一班的所有学生
    List<User> findAll();

    //通过输入的年级班级查学生
    List<User> selectStudentByGradeAndClass(Map<String, String> map);

    List<User> selectStudentById(List<Integer> list);

    //调用存储过程删除数据
    int deleteFromProcedure(int tid);
}
