package sky.pro.coursework2questionsfortheexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework2questionsfortheexam.Question;
import sky.pro.coursework2questionsfortheexam.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestion(amount);
    }
}
