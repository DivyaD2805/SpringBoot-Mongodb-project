package com.example.demo.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
     Student findByFirstName(String firstName);
     Student findByUsn(String usn);
}
