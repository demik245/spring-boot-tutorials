package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Course;
import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;

import java.util.List;


public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(Long id);

    void deleteInstructorById(Long id);

    InstructorDetail findInstructorDetailById(Long id);

    void deleteInstructorDetailById(Long id);

    List<Course> findCoursesByInstructorId(Long id);

    Instructor findInstructorByIdJoinFetch(Long id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(Long id);

    void deleteCourseById(Long id);

    void save(Course course);


}
