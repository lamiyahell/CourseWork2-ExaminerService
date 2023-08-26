package sky.pro.coursework2questionsfortheexam.service;

import org.springframework.stereotype.Service;
import sky.pro.coursework2questionsfortheexam.Question;
import sky.pro.coursework2questionsfortheexam.exception.QuestionAlreadyAddedException;
import sky.pro.coursework2questionsfortheexam.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions;

    public QuestionService questionService;

    public JavaQuestionService(QuestionService questionService) {
        this.questionService = questionService;
        this.questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        return add(newQuestion);
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        return add(question);
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question) {
            return remove(question);
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int random = new Random().nextInt();
        return null;
    }
}
