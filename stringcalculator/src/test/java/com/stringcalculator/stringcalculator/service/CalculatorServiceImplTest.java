package com.stringcalculator.stringcalculator.service;

import com.stringcalculator.stringcalculator.custom.exception.NegativeValuesNotAllowedException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceImplTest {

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    /*1. When only 1 number present in the input, e.g "3" = 3*/
    @Test
    public final void whenOneNumberThenReturnValueIsThatSameNumber() {
        assertEquals("3", calculatorService.getAdditionResult("3"));
    }

    /*1. adds numbers present in the input, e.g "3,6" = 9*/
    @Test
    public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
        assertEquals("9", calculatorService.getAdditionResult("3,6"));
    }

    /*1. adds numbers present in the input, e.g "3,6" = 9*/
    @Test
    public final void whenEmptyStringIsUsedThenReturnValueIs0() {
        assertEquals("0", calculatorService.getAdditionResult(""));
    }

    /*1. adds numbers present in the input, e.g "3,6" = 9*/
    @Test
    public final void whenNullIsUsedThenReturnValueIs0() {
        assertEquals("0", calculatorService.getAdditionResult(null));
    }

    /*1. adds numbers present in the input, e.g "3,6,15,0,25,33" = all those sum*/
    @Test
    public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
        assertEquals(String.valueOf(3+6+15+0+25+33), calculatorService.getAdditionResult("3,6,15,0,25,33"));
    }

    /*3. supports different delimiters, e.g "1,2,3", "1 2 3"*/
    @Test
    public final void whenUsedDeffentDelimeter() {
        assertEquals(String.valueOf(3+6+15+0+25+33), calculatorService.getAdditionResult("3 6 15 0 25 33"));
    }

    /*4.does not support negative numbers*/
    @Test
    public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
        NegativeValuesNotAllowedException negativeValuesNotAllowedException=assertThrows(NegativeValuesNotAllowedException.class,()->calculatorService.getAdditionResult("3,-6,15,-18,46,33"));
        assertEquals(negativeValuesNotAllowedException.getErrorMessage(),"Negatives numbers are not allowed: [-6, -18]");
    }

    /*5.ignores numbers greater than 100*/
    @Test
    public final void whenOneOrMoreNumbersAreGreaterThan100IsUsedThenItIsNotIncludedInSum() {
        assertEquals(String.valueOf(3+6), calculatorService.getAdditionResult("3,1000,1520,6,150"));
    }

    @Test
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        assertThrows(RuntimeException.class,()->calculatorService.getAdditionResult("1,X"));
    }


}
