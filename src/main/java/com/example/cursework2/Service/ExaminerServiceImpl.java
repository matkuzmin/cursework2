package com.example.cursework2.Service;

import com.example.cursework2.Exeption.QuestionExceededExeption;
import com.example.cursework2.Question;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements IExaminerService {
    Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        Set<Question> all = questionService.getAll();
        if (all.size() < amount) {
            throw new QuestionExceededExeption();
        }
        if (all.size() == amount) {
            return all;
        }
        Set<Question> examer = new HashSet<>(amount);
        while (examer.size() < amount) {
            examer.add(questionService.getRandomQuestion());
        }
        return examer;
    }
}
