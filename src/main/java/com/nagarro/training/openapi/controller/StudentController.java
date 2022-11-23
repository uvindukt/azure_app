/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.openapi.api.StudentsApi;
import com.nagarro.training.openapi.dto.ResponseDTO;
import com.nagarro.training.openapi.dto.StudentDTO;
import com.nagarro.training.openapi.facade.StudentServiceFacade;

/**
 * Student Controller
 */
@CrossOrigin(origins = "*")
@RestController(value = "/students")
public class StudentController implements StudentsApi {

	private StudentServiceFacade studentServiceFacade;

	@Autowired
	public StudentController(StudentServiceFacade studentServiceFacade) {
		this.studentServiceFacade = studentServiceFacade;
	}

	@Override
	public ResponseEntity<ResponseDTO> addStudent(@Valid StudentDTO studentDTO) {

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Student added successfully");
		responseDTO.status(HttpStatus.OK.value());
		responseDTO.data(studentServiceFacade.addStudent(studentDTO));

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseDTO> deleteStudent(Long id) {

		studentServiceFacade.deleteStudent(id);

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Student deleted successfully");
		responseDTO.status(HttpStatus.OK.value());

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseDTO> getStudent(Long id) {

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Student retrieved successfully");
		responseDTO.status(HttpStatus.OK.value());
		responseDTO.data(studentServiceFacade.getStudentById(id));

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseDTO> getStudents() {

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Students retrieved successfully");
		responseDTO.status(HttpStatus.OK.value());
		responseDTO.data(studentServiceFacade.getAllStudents());

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<ResponseDTO> updateStudent(@Valid StudentDTO studentDTO) {

		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO.setMessage("Student updated successfully");
		responseDTO.status(HttpStatus.OK.value());
		responseDTO.data(studentServiceFacade.updateStudent(studentDTO));

		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

}
