package com.example.demo.controller;

import com.example.demo.exception.ExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
public class StudentExceptionController extends RuntimeException {
    @ExceptionHandler(StudentExceptionController.class)

    public ResponseEntity<Object> handleAddStudentFailException(StudentExceptionController exception) {
        log.error("Added fail!");
        log.warn("Present age is less than 18, you should re-check");
        log.info("Age must be over or equal to 18; ex: 18, 19 or 20");
        ExceptionResult exceptionResult = new ExceptionResult(HttpStatus.BAD_REQUEST.toString(), "Add failure! Age must be over or equal to 18");
        return new ResponseEntity<>(exceptionResult, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)

    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
        log.error("Not found student");
        log.warn("Check and re-enter");
        log.info("The age you entered is not in the data");
        ExceptionResult exceptionResult = new ExceptionResult(HttpStatus.BAD_REQUEST.toString(), "Not found age");
        return new ResponseEntity<>(exceptionResult, HttpStatus.BAD_REQUEST);
    }

}
