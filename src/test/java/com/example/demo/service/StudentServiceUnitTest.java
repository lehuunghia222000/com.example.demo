package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceUnitTest {
	@Autowired
	private StudentService studentService;
	@MockBean
	private StudentRepository studentRepository;
	@Test
	public void findByAgeIs(){
		List<Student> expected = new ArrayList<>();
		Mockito.when(studentRepository.findByAgeIs(21)).thenReturn(expected);
		List<Student> actual = studentService.findByAgeIs(21);
		Assertions.assertArrayEquals(expected.toArray(),actual.toArray());
	}

}
