package sky.pro.coursework2questionsfortheexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework2questionsfortheexam.Question;
import sky.pro.coursework2questionsfortheexam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/java/add")
    private Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/java/remove")
    private Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(question);
    }

    @GetMapping("/java")
    private Collection<Question> getQuestions() {
        return service.getAll();
    }
}
