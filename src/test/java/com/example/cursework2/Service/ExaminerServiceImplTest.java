package com.example.cursework2.Service;

import com.example.cursework2.Exeption.QuestionExceededExeption;
import com.example.cursework2.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
@Mock
private QuestionService questionService;
private ExaminerServiceImpl examinerService;




@BeforeEach
void setUp(){
   examinerService = new ExaminerServiceImpl(questionService);
}
    @Test
    void getQuestions() {
    Set<Question> questions = new HashSet<>();
     questions.add(new Question("a1","a1"));
     questions.add(new Question("a2","a2"));
     questions.add(new Question("a3","a3"));
     Question question = new Question("a1","a1");
        Mockito.when(questionService.getAll()).thenReturn(questions);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(question);
        var expected = examinerService.getQuestions(1);
         Set<Question> actual = new HashSet<>();
         actual.add(new Question("a1","a1"));
      assertEquals(expected,actual);
        assertThrows(QuestionExceededExeption.class,()->examinerService.getQuestions(10));
    }
}