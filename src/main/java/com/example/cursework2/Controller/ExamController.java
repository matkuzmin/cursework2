package com.example.cursework2.Controller;

import com.example.cursework2.Exeption.QuestionExceededExeption;
import com.example.cursework2.Question;
import com.example.cursework2.Service.IExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final IExaminerService examinerService;

    public ExamController(IExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping(path = "/get/{amount}")
    public Set<Question> getQuestions(@PathVariable int amount) {
        try {
            return examinerService.getQuestions(amount);
        } catch (QuestionExceededExeption e) {
            System.out.println("Количество запрошенных вопросв привешает количество в списке");
        }
        return null;
    }
}
