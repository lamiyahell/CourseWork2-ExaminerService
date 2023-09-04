package sky.pro.coursework2questionsfortheexam.service;

import sky.pro.coursework2questionsfortheexam.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}