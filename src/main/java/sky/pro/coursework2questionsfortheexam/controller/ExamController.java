package sky.pro.coursework2questionsfortheexam.controller;

import org.springframework.web.bind.annotation.*;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}