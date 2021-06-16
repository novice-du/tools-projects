package com.djh.demo.Entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {

    private String name;    //姓名
    private int id;         //id
    private String nameOfGrade;   //年级
    private String nameOfClass;  //班级名

}
