/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nagarro.training.openapi.dto.StudentDTO;

/**
 * A Facade definition for Student related services
 */
@Service
public interface StudentServiceFacade {

	/**
	 * Adds a new student
	 * 
	 * @param studentDTO student DTO
	 * @return StudentDTO
	 */
	public StudentDTO addStudent(StudentDTO studentDTO);

	/**
	 * Retrieves all students.
	 * 
	 * @return List<StudentDTO>
	 */
	public List<StudentDTO> getAllStudents();

	/**
	 * Retrieves a student by provided ID
	 * 
	 * @param id student ID
	 * @return StudentDTO
	 */
	public StudentDTO getStudentById(Long id);

	/**
	 * Updates a student from provided ID
	 * 
	 * @param studentDTO
	 * @return StudentDTO
	 */
	public StudentDTO updateStudent(StudentDTO studentDTO);

	/**
	 * Deletes a student by provided ID
	 * 
	 * @param id student ID
	 */
	public void deleteStudent(Long id);

}
