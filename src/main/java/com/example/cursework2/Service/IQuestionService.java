package com.example.cursework2.Service;

import com.example.cursework2.Question;

import java.util.Collection;
import java.util.Set;

public interface IQuestionService {
    Question questionAdd(String question, String answer);

    Question questionAdd(Question question);

    Question questionRemove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
