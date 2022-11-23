/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.service;

import java.util.List;

import com.nagarro.training.openapi.model.Student;

/**
 * Services for student domain
 */
public interface StudentService {

	/**
	 * Adds a new student to the system
	 * 
	 * @param student Student to be added
	 * @return Student
	 */
	public Student addStudent(Student student);

	/**
	 * Retrieves all the students from system
	 * 
	 * @return List<Student>
	 */
	public List<Student> getAllStudents();

	/**
	 * Retrieves a student by ID
	 * 
	 * @param id Student ID
	 * @return Student
	 */
	public Student getStudentById(Long id);

	/**
	 * Updates a student by ID
	 * 
	 * @param updatedStudent student with new details
	 * @return Student
	 */
	public Student updateStudent(Student updatedStudent);

	/**
	 * Deletes a student by ID
	 * 
	 * @param id Student ID
	 */
	public void deleteStudent(Long id);

}
