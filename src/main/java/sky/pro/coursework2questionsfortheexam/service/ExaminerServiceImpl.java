package sky.pro.coursework2questionsfortheexam.service;

import org.springframework.stereotype.Service;
import sky.pro.coursework2questionsfortheexam.Question;

import java.util.Collection;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.random = new Random();
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        questionService.getRandomQuestion(amount);
    }
}

