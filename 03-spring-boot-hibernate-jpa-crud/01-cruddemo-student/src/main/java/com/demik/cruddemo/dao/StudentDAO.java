package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student thestudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
