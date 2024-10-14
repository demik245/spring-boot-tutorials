package com.demik.cruddemo;

import com.demik.cruddemo.dao.StudentDAO;
import com.demik.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			//createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count" + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;

		System.out.println("Removing student with id: " + studentId);

		Student theStudent = studentDAO.findById(studentId);

		studentDAO.delete(studentId);

		System.out.println("Deleted student: " + theStudent);

	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Z");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
	    System.out.println("Creating new student object");
		Student tempStudent = new Student("Cole", "Jay", "JayCole@yahoo.com");

		// save the student
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students

		System.out.println("Creating a new students...");
		Student tempStudent1 = new Student("Rodrigo", "Olivia", "email@gmail.com");
		Student tempStudent2 = new Student("West", "Kayne", "kayne@yahoo.com");
		Student tempStudent3 = new Student("Z", "JAY", "jay@gmail.com"  );

		// save the student object
	    System.out.println("Saving students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating a new student...");
		Student tempStudent = new Student("Marciniec", "Damian", "damianmar17@outlook.com");

		// save the student object
		System.out.println("Saving student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student id: " + tempStudent.getId());

	}



}
