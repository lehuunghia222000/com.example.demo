package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> findByAgeIs(Integer age){
        List<Student> students;
        if (age == null)
            students = studentRepository.findAll();
        else
            students = studentRepository.findByAgeIs(age);
        return students;
    }
//    public List<Student> findByAgeIs(int age){
//        List<Student> students = studentRepository.findByAgeIs(age);
//        return students;
//    }
    public Student addStudent(Student student){
        Student student1 = studentRepository.save(student);
        return student1;
    }
    public Student updateStudent(Student newStudent, Integer id){
        Student student = studentRepository.findById(id).get();
        student.setFName(newStudent.getFName());
        student.setLName(newStudent.getLName());
        student.setAge(newStudent.getAge());
        student.setClassName(newStudent.getClassName());
        Student upStudent = studentRepository.save(student);
        return  upStudent;
    }

    public ResponseEntity<?> deleteStudent(Integer id){
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
}
