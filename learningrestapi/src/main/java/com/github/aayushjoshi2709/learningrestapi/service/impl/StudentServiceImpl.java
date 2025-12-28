package com.github.aayushjoshi2709.learningrestapi.service.impl;

import com.github.aayushjoshi2709.learningrestapi.dto.AddStudentRequestDto;
import com.github.aayushjoshi2709.learningrestapi.dto.StudentDto;
import com.github.aayushjoshi2709.learningrestapi.entity.Student;
import com.github.aayushjoshi2709.learningrestapi.repository.StudentRepository;
import com.github.aayushjoshi2709.learningrestapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

//    automatically created by @RequiredArgsConstructor
//    public StudentServiceImpl(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(student -> {
           //return new StudentDto(student.getId(), student.getName(), student.getEmail());
            return modelMapper.map(student, StudentDto.class);
        }).toList();
    }

    public StudentDto getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Student not found with id: " + id)
        );
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequest) {
        Student newStudent = modelMapper.map(addStudentRequest, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudentById(Long id, AddStudentRequestDto updateStudentDto) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found with id: " + id)
        );
        modelMapper.map(updateStudentDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        final Student student = studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found with id: " + id)
        );
        updates.forEach((field, value)-> {
            switch (field){
                case "name":
                    student.setName((String) value);
                    break;
                case "email":
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}
