/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.openapi.exception.ServiceException;
import com.nagarro.training.openapi.model.Student;
import com.nagarro.training.openapi.repository.StudentRepository;

/**
 * Student service implementation
 */
@Service
public class StudentServiceImpl implements StudentService {

	private static final String SERVICE_ERROR = "Student service failed";
	private static final String NOT_FOUND_ERROR = "Student not found";
	private static final String NOT_FOUND_LIST_ERROR = "Students not found";
	private static final String VALIDATION_ERROR = "Invalid student ";

	private StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z ]*$");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Student addStudent(Student student) {

		try {

			if (!NAME_PATTERN.matcher(student.getName()).matches()) {
				throw new IllegalArgumentException(VALIDATION_ERROR + "name");
			}

			if (student.getAge() < 1 || student.getAge() > 120) {
				throw new IllegalArgumentException(VALIDATION_ERROR + "age");
			}

			return studentRepository.save(student);

		} catch (IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new ServiceException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Student> getAllStudents() {

		try {

			List<Student> students = studentRepository.findAll();

			if (students.isEmpty()) {
				throw new EntityNotFoundException(NOT_FOUND_LIST_ERROR);
			}

			return students;

		} catch (EntityNotFoundException e) {

			throw e;

		} catch (Exception e) {

			throw new ServiceException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Student getStudentById(Long id) {

		try {

			Optional<Student> studentOptional = studentRepository.findById(id);

			if (studentOptional.isEmpty()) {
				throw new EntityNotFoundException(NOT_FOUND_ERROR);
			}

			return studentOptional.get();

		} catch (EntityNotFoundException e) {

			throw e;

		} catch (Exception e) {

			throw new ServiceException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Student updateStudent(Student updatedStudent) {

		try {

			Optional<Student> studentOptional = studentRepository.findById(updatedStudent.getId());

			if (studentOptional.isEmpty()) {
				throw new EntityNotFoundException(NOT_FOUND_ERROR);
			}

			Student student = studentOptional.get();

			if (!NAME_PATTERN.matcher(updatedStudent.getName()).matches()) {
				throw new IllegalArgumentException(VALIDATION_ERROR + "name");
			}

			if (student.getAge() < 1 || updatedStudent.getAge() > 120) {
				throw new IllegalArgumentException(VALIDATION_ERROR + "age");
			}

			student.setName(updatedStudent.getName());
			student.setAge(updatedStudent.getAge());

			return studentRepository.save(student);

		} catch (EntityNotFoundException | IllegalArgumentException e) {

			throw e;

		} catch (Exception e) {

			throw new ServiceException(SERVICE_ERROR, e);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteStudent(Long id) {

		try {

			Optional<Student> studentOptional = studentRepository.findById(id);

			if (studentOptional.isEmpty()) {
				throw new EntityNotFoundException(NOT_FOUND_ERROR);
			}

			studentRepository.delete(studentOptional.get());

		} catch (EntityNotFoundException e) {

			throw e;

		} catch (Exception e) {

			throw new ServiceException(SERVICE_ERROR, e);

		}

	}

}
