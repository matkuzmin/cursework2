package com.example.cursework2.Controller;

import com.example.cursework2.Question;
import com.example.cursework2.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class Controller {
    private final IQuestionService questionService;

    public Controller(IQuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/add")
    public Question add(@RequestParam String questions, @RequestParam String answer) {
        return questionService.questionAdd(questions, answer);
    }

    @GetMapping("/remove")
    public Question remove(String questions, @RequestParam String answer) {
        return questionService.questionRemove(new Question(questions, answer));
    }

    @GetMapping()
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
