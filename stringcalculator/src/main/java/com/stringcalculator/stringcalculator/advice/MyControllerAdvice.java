package com.stringcalculator.stringcalculator.advice;

import com.stringcalculator.stringcalculator.custom.exception.NegativeValuesNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(NegativeValuesNotAllowedException.class)
    public ResponseEntity<String> handleNegativeValues(){

        return new ResponseEntity<String>("Negatives not allowed: Please Look into it", HttpStatus.BAD_REQUEST);
    }
}
