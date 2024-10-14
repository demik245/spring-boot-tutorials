package com.demik.cruddemo;

import com.demik.cruddemo.dao.StudentDAO;
import com.demik.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createMultipleStudents(studentDAO);

			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("fdsafs", "gdsga", "sraka@gmail.com");
		studentDAO.save(tempStudent1);

		int theId = tempStudent1.getId();

		System.out.println("Created student with id " + theId);

		Student myStudent = studentDAO.findById(theId);
		System.out.println("Student with provided id: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student tempStudent1 = new Student("Marciniec", "Damian", "damianmar17@outlook.com");
		Student tempStudent2 = new Student("Marciniec", "Damianek", "dmarciniec142@gmail.com");

		studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
	}


}
