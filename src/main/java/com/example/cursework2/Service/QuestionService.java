package com.example.cursework2.Service;

import com.example.cursework2.Question;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class QuestionService implements IQuestionService {
    private final Set<Question> examQuestion = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question questionAdd(String question, String answer) {

        return questionAdd(new Question(question, answer));
    }


    @Override
    public Question questionAdd(Question question) {
        examQuestion.add(question);
        return question;

    }

    @Override
    public Question questionRemove(Question question) {
        if (examQuestion.remove(question)) {
            return question;
        }
        return null;

    }

    @Override
    public Set<Question> getAll() {
        return Collections.unmodifiableSet(examQuestion);
    }

    @Override
    public Question getRandomQuestion() {
        var index = random.nextInt(examQuestion.size());
        int i = 0;
        for (Question question : examQuestion) {
            if (index == i) {
                return question;
            }
            i++;
        }
        return null;
    }
}
