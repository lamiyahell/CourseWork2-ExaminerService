package sky.pro.coursework2questionsfortheexam.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.coursework2questionsfortheexam.exception.IncorrectQuestionAmountException;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.service.impl.ExaminerServiceImpl;

import java.util.Collection;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static sky.pro.coursework2questionsfortheexam.service.QuestionTestConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void shouldThrowIncorrectQuestionAmountException() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);

        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        assertThatExceptionOfType(IncorrectQuestionAmountException.class)
                .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));
    }

    @Test
    public void shouldReturnQuestions() {
        when(questionService.getAll()).thenReturn(MOCK_QUESTIONS);
        when(questionService.getRandomQuestion()).thenReturn(
                QUESTION_1,
                QUESTION_2,
                QUESTION_3,
                QUESTION_4,
                QUESTION_5
        );

        int questionAmount = MOCK_QUESTIONS.size() - 2;

        assertThat(examinerService.getQuestions(questionAmount)).hasSize(questionAmount);
    }
}