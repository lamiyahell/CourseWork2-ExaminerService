package sky.pro.coursework2questionsfortheexam.service.impl;

import org.springframework.stereotype.Service;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.exception.QuestionNotFoundException;
import sky.pro.coursework2questionsfortheexam.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
            return add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
            questions.add(question);
            return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.remove(question)) {
            throw new QuestionNotFoundException();
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        int questionIndex = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(questionIndex);
    }
}