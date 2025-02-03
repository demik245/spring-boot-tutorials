package com.demik.cruddemo.dao;

import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
