package com.example.cursework2.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionExceededExeption extends RuntimeException{
    public QuestionExceededExeption() {
    }

    public QuestionExceededExeption(String message) {
        super(message);
    }

    public QuestionExceededExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionExceededExeption(Throwable cause) {
        super(cause);
    }

    public QuestionExceededExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
