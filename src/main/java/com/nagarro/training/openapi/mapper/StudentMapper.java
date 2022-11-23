/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nagarro.training.openapi.dto.StudentDTO;
import com.nagarro.training.openapi.model.Student;

/**
 * Model <-> DTO mapper for student
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

	public StudentDTO modelToDto(Student student);

	@InheritInverseConfiguration
	public Student dtoToModel(StudentDTO studentDTO);

	public List<StudentDTO> modelsToDtos(List<Student> students);

}
