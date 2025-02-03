package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(Long id);

    void deleteInstructorById(Long id);

    InstructorDetail findInstructorDetailById(Long id);

    void deleteInstructorDetailById(Long id);
}
