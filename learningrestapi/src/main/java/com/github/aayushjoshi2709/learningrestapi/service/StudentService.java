package com.github.aayushjoshi2709.learningrestapi.service;


import com.github.aayushjoshi2709.learningrestapi.dto.AddStudentRequestDto;
import com.github.aayushjoshi2709.learningrestapi.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequest);

    void deleteStudentById(Long id);

    StudentDto updateStudentById(Long id, AddStudentRequestDto updateStudentDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
