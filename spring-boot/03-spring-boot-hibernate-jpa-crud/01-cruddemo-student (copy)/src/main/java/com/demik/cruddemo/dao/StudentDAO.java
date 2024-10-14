package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer Id);
}
