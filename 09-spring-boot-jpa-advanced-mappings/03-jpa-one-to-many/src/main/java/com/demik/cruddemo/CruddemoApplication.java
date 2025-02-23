package com.demik.cruddemo;

import com.demik.cruddemo.dao.AppDAO;
import com.demik.cruddemo.entity.Course;
import com.demik.cruddemo.entity.Instructor;
import com.demik.cruddemo.entity.InstructorDetail;
import com.demik.cruddemo.entity.Review;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// deleteInstructorDetail(appDAO);

			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorByIdJoinFetch(appDAO);

			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			// deleteCourse(appDAO);

			createCourseAndReviews(appDAO);
		};
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("ELO123");

		course.addReview(new Review("elo"));
		course.addReview(new Review("siema"));
		course.addReview(new Review("eluwina"));

		System.out.println("Saving course: " + course);
		System.out.println("Saving reviews: " + course.getReviews());
		appDAO.save(course);


		System.out.println("Done");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;


		System.out.println("Deleting course with id: " + theId);

		appDAO.deleteCourseById((long) theId);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseById((long) id);
		System.out.println("Updating Course: " + course);

		course.setTitle("javaXDD");

		appDAO.update(course);

		System.out.println("updated Course: " + course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		Instructor instructor = appDAO.findInstructorById((long) id);
		System.out.println("Updating Instructor: " + instructor);

		instructor.setFirstName("XDDDDDDDDDDDD");

		appDAO.update(instructor);

		System.out.println("updated Instructor: " + instructor);
	}

	private void findInstructorByIdJoinFetch(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with courses with id: " + theId);

		Instructor instructor = appDAO.findInstructorByIdJoinFetch((long) theId);

		System.out.println(instructor);
		System.out.println("the associate courses only: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;

		Instructor instructor = appDAO.findInstructorById((long) theId);
		System.out.println("instructor: " + instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId((long) theId);;

		instructor.setCourses(courses);

		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor with courses with id: " + theId);

		Instructor instructor = appDAO.findInstructorById((long) theId);

		System.out.println(instructor);
		System.out.println("the associate courses only: " + instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor(
				"Damian",
				"Marciniec",
				"damianmar17@outlook.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"youtube.com/damianmar17",
				"coding");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Java");
		Course course2 = new Course("Rust");
		Course course3 = new Course("sanki");

		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving courses: " + instructor.getCourses());

		appDAO.save(instructor);

		System.out.println("Done");
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

		int theId = 1;
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
