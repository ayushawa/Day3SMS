package com.example.day3ms.controller;

import com.example.day3ms.model.StudentModel;
import com.example.day3ms.service.StudentService;
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
    public StudentModel addStudent(@RequestBody StudentModel student){
        return service.addStudent(student);
    }


    @GetMapping("/students")
    public List<StudentModel> getStudents(){
        return service.getStudents();
    }

    @PutMapping("/update/{id}")
    public StudentModel updateStudent(@PathVariable String id, @RequestBody StudentModel student){
        return service.updateStudent(id,student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.deleteStudent(id);

    }

}
