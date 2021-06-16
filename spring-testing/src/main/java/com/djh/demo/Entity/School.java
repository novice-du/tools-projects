package com.djh.demo.Entity;

import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class School {
    private String nameOfGrade;    //年级
    private String nameOfClass;    //班级
    private String headMaster;     //班主任名称
    private List<User> userList;
}
