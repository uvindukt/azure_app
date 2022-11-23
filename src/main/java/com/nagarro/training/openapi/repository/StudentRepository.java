/**
 * @author uvindusanjana
 */
package com.nagarro.training.openapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.openapi.model.Student;

/**
 * JPA Repository for Student domain
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
