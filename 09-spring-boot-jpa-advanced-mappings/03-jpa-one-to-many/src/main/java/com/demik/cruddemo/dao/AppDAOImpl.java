package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Course;
import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {


    EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Long id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        for (Course course : instructor.getCourses()) {
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(Long id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Long id) {

        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(Long id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",
                Course.class);
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Long id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i" +
                        " join fetch i.courses" +
                        " join fetch i.instructorDetail" +
                        " where i.id = :data",
                Instructor.class);
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}