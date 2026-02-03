package com.example.day3ms.controller;

import com.example.day3ms.dto.StudentRequestDto;
import com.example.day3ms.dto.StudentResponseDto;
import com.example.day3ms.model.StudentModel;
import com.example.day3ms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @GetMapping("/")
    public String home(){
        return "welcome to home page....";
    }
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping("/addStudent")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentRequestDto student){
        return service.addStudent(student);
    }


    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(){
        return service.getAllStudents();
    }

    @PutMapping("/update/{id}")
    public StudentResponseDto updateStudent(@PathVariable String id, @RequestBody StudentRequestDto student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.deleteStudent(id);

    }

}
