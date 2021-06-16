package com.djh.demo.Lombda.why2;

import com.djh.demo.Lombda.Student;

public class CompareByAge implements Compare {
    @Override
    public boolean compare(Student student) {
        return student.getAge()>10;
    }
}
