package sky.pro.coursework2questionsfortheexam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService service;

    public JavaController(QuestionService service) {
        this.service = service;
    }

    @GetMapping("/add")
    private Question add(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("/remove")
    private Question remove(@RequestParam String question, @RequestParam String answer) {
        Question questionForRemove = new Question(question, answer);
        return service.remove(questionForRemove);
    }

    @GetMapping
    private Collection<Question> getAll() {
        return service.getAll();
    }
}