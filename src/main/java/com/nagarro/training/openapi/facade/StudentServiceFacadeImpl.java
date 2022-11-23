/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.facade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.training.openapi.dto.StudentDTO;
import com.nagarro.training.openapi.exception.FacadeException;
import com.nagarro.training.openapi.exception.ServiceException;
import com.nagarro.training.openapi.mapper.StudentMapper;
import com.nagarro.training.openapi.model.Student;
import com.nagarro.training.openapi.service.StudentService;

/**
 * Student service facade implementation
 */
@Service
public class StudentServiceFacadeImpl implements StudentServiceFacade {

	private static final String SERVICE_ERROR = "Student service facade failed";

	private StudentService studentService;
	private StudentMapper studentMapper;

	@Autowired
	public StudentServiceFacadeImpl(StudentService studentService, StudentMapper studentMapper) {
		this.studentService = studentService;
		this.studentMapper = studentMapper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) {

		try {

			Student student = studentMapper.dtoToModel(studentDTO);

			return studentMapper.modelToDto(studentService.addStudent(student));

		} catch (ServiceException | IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new FacadeException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<StudentDTO> getAllStudents() {

		try {

			List<Student> students = studentService.getAllStudents();

			if (students.isEmpty()) {
				return new ArrayList<>();
			}

			return studentMapper.modelsToDtos(students);

		} catch (ServiceException | EntityNotFoundException e) {

			throw e;

		} catch (Exception e) {

			throw new FacadeException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public StudentDTO getStudentById(Long id) {

		try {

			return studentMapper.modelToDto(studentService.getStudentById(id));

		} catch (ServiceException | EntityNotFoundException | IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new FacadeException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {

		try {

			Student student = studentMapper.dtoToModel(studentDTO);

			return studentMapper.modelToDto(studentService.updateStudent(student));

		} catch (ServiceException | EntityNotFoundException | IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new FacadeException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional
	@Override
	public void deleteStudent(Long id) {

		try {

			studentService.deleteStudent(id);

		} catch (ServiceException | EntityNotFoundException | IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new FacadeException(SERVICE_ERROR, e);

		}

	}

}
