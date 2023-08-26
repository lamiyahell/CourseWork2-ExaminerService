package sky.pro.coursework2questionsfortheexam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAddedException extends RuntimeException{
    public QuestionAlreadyAddedException() {
    }
}
