package com.example.day3ms.service;

import com.example.day3ms.dto.StudentRequestDto;
import com.example.day3ms.dto.StudentResponseDto;
import com.example.day3ms.exception.StudentNotFoundException;
import com.example.day3ms.model.StudentModel;
import com.example.day3ms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private  StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

//    public StudentModel addStudent(StudentModel student){
//        return repository.save(student);
//    }
    public StudentResponseDto addStudent(StudentRequestDto dto){
        StudentModel student  = new StudentModel();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        StudentModel saved = repository.save(student);

        return new StudentResponseDto(
                saved.getId(),
                saved.getName(),
                saved.getAge(),
                saved.getEmail()
        );
    }

    public List<StudentModel> getStudents(){
        return repository.findAll();
    }
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(s-> new StudentResponseDto(
                        s.getId(),
                        s.getName(),
                        s.getAge(),
                        s.getEmail()
                )).toList();
    }
    // update
    public StudentResponseDto updateStudent(String id,StudentRequestDto dto){
        StudentModel existingStudent = repository.findById(id)
                .orElseThrow(()->new RuntimeException("No student found"));

        existingStudent.setName(dto.getName());
        existingStudent.setAge(dto.getAge());
        existingStudent.setEmail(dto.getEmail());
        StudentModel updated = repository.save(existingStudent);
        return new StudentResponseDto(
                updated.getId(),
                updated.getName(),
                updated.getAge(),
                updated.getEmail()
        );
    }

    public void deleteStudent(String id){
        if(!repository.existsById(id)){
            throw new StudentNotFoundException("No student found with this id");
        }
        repository.deleteById(id);
    }
}
