package com.stringcalculator.stringcalculator.controller;

import com.stringcalculator.stringcalculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add")
    public ResponseEntity<?> getAdditionResult(@RequestParam(name="calculate")String calculate){
       return new ResponseEntity<String>(calculatorService.getAdditionResult(calculate), HttpStatus.OK);
    }
}
