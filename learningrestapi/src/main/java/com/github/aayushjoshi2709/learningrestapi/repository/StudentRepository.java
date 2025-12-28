package com.github.aayushjoshi2709.learningrestapi.repository;

import com.github.aayushjoshi2709.learningrestapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
