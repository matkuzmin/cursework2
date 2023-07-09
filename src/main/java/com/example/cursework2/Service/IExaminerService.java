package com.example.cursework2.Service;

import com.example.cursework2.Question;

import java.util.Set;

public interface IExaminerService {
    Set<Question> getQuestions(int a);
}
