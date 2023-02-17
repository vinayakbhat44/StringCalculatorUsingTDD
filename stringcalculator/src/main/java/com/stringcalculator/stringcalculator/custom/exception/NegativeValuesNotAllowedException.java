package com.stringcalculator.stringcalculator.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class NegativeValuesNotAllowedException extends RuntimeException{

    private String errorCode;
    private String errorMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public NegativeValuesNotAllowedException( String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public NegativeValuesNotAllowedException(){


    }
}
