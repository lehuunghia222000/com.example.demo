package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
@Validated
@RequestMapping(value = "/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudent(@Valid @RequestParam(required = false) @Min(18) Integer age){
//        if (age == null)
        return studentService.findByAgeIs(age);
//        else
//            return studentService.findByAgeIs(age);
    }
//    @GetMapping("/age")
//    public List<Student> getStudentByAge(@Valid @RequestParam(required = false) @Min(18) int age){
//
//    }
    @PostMapping("/")
    public Student postStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student putStudent(@RequestBody Student student, @PathVariable Integer id){
        return studentService.updateStudent(student, id);
    }
    @PostMapping("/validation")
    public ResponseEntity<Object> postStudent(@Validated @RequestBody Student student, BindingResult result){
        if (result.hasErrors()) throw new StudentExceptionController();
        studentService.addStudent(student);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }

}
