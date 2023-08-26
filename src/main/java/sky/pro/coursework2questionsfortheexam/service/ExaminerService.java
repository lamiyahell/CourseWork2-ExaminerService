package sky.pro.coursework2questionsfortheexam.service;

import sky.pro.coursework2questionsfortheexam.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
