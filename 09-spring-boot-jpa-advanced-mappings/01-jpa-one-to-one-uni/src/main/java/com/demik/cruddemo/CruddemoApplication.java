package com.demik.cruddemo;

import com.demik.cruddemo.dao.AppDAO;
import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			 // createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 5;
		System.out.println("Deleting instructorDetail with id: " + theId);

		appDAO.deleteInstructorDetailById((long) theId);

		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructorDetail with id: " + theId);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById((long) theId);

		System.out.println(instructorDetail);
		System.out.println("the associate instructor only: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Deleting instructor with id: " + theId);

		appDAO.deleteInstructorById((long) theId);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor with id: " + theId);

		Instructor instructor = appDAO.findInstructorById((long) theId);

		System.out.println(instructor);
		System.out.println("the associate instructorDetails only: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Damian",
				"Marciniec",
				"damianmar17@outlook.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"youtube.com/damianmar17",
				"coding");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);

		appDAO.save(instructor);

		System.out.println("Done");

//		Instructor instructor = new Instructor(
//				"Filip",
//				"Mita",
//				"filipmita@gmail.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail(
//				"youtube.com/filipmita",
//				"coding");
//
//		instructor.setInstructorDetail(instructorDetail);
//
//		System.out.println("Saving instructor: " + instructor);
//
//		appDAO.save(instructor);
//
//		System.out.println("Done");

	}

}
