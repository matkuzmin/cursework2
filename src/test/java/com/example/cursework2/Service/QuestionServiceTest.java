package com.example.cursework2.Service;

import com.example.cursework2.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuestionServiceTest {
QuestionService questionService;
@BeforeEach
void beForeEach(){

    questionService = new QuestionService();
}
    @Test
    void questionAddTest() {
        Question expected = questionService.questionAdd("a1","a1");
        Question actual = new Question("a1","a1");
        assertEquals(expected,actual);
        Question expected1 = questionService.questionAdd("a1","a1");
        assertEquals(questionService.getAll().size(),1);
    }



    @Test
    void questionRemove() {
        Question expected1 = questionService.questionAdd("a1","a1");
        Question expected3 = new Question("a","a");
        Question expected = questionService.questionRemove(expected1);
        Question expected2 = questionService.questionRemove(expected3);
        assertEquals(expected2,null);

    }

    @Test
    void getAll() {
        Question expected = questionService.questionAdd("a1","a1");
        Question expected1 = questionService.questionAdd("a2","a2");
        Question expected2 = questionService.questionAdd("a3","a3");
        Set<Question> actual = new HashSet<>();
        actual.add ( new Question("a1","a1"));
        actual.add ( new Question("a2","a2"));
        actual.add ( new Question("a3","a3"));
        assertEquals(questionService.getAll(),actual);
        assertEquals(questionService.getAll().size(),actual.size());
    }

}