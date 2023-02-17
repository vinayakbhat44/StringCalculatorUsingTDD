package com.stringcalculator.stringcalculator.service;

import com.stringcalculator.stringcalculator.custom.exception.NegativeValuesNotAllowedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public String getAdditionResult(String calculate) {
        if(calculate==null){
            return String.valueOf(0);
        }
        String delimiter = ",| ";
        String numbersWithoutDelimiter = calculate;

        return String.valueOf(add(numbersWithoutDelimiter, delimiter));

    }

    private int add(final String numbers, final String delimiter) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(delimiter);
        List negativeNumbers = new ArrayList();
        for (String number : numbersArray) {
            if(number==null || number==""){
                returnValue += 0;
            }
            else if (!number.trim().isEmpty()) {
                int numberInt = Integer.parseInt(number.trim());
                if (numberInt < 0) {
                    negativeNumbers.add(numberInt);
                } else if (numberInt <= 100) {
                    returnValue += numberInt;
                }
            }
        }
        if (negativeNumbers.size() > 0) {
            throw new NegativeValuesNotAllowedException("701","Negatives numbers are not allowed: " + negativeNumbers.toString());
        }
        return returnValue;
    }
}
