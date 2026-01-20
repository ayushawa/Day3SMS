package com.example.day3ms.repository;

import com.example.day3ms.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository  extends MongoRepository <StudentModel,String> {

}
