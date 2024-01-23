package com.alina.spring.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public EmployeeIncorrectData handleException(NoSuchEmployeeException exception){
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return incorrectData;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public EmployeeIncorrectData handleException(Throwable exception){
        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return incorrectData;
    }
}
