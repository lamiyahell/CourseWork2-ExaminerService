package sky.pro.coursework2questionsfortheexam.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.exception.IncorrectQuestionAmountException;
import sky.pro.coursework2questionsfortheexam.service.ExaminerService;
import sky.pro.coursework2questionsfortheexam.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int questionCount = questionService.getAll().size();
        if (amount <= 0 || amount > questionCount) {
            throw new IncorrectQuestionAmountException();
        }
        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            questions.add(questionService.getRandomQuestion());
        }
        return questions;
    }
}