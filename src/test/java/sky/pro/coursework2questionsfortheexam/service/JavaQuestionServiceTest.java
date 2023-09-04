package sky.pro.coursework2questionsfortheexam.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sky.pro.coursework2questionsfortheexam.model.Question;
import sky.pro.coursework2questionsfortheexam.exception.QuestionNotFoundException;
import sky.pro.coursework2questionsfortheexam.service.impl.JavaQuestionService;

import static org.assertj.core.api.Assertions.*;
import static sky.pro.coursework2questionsfortheexam.service.QuestionTestConstants.*;

class JavaQuestionServiceTest {

    private static final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach() {
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }

    @Test
    public void shouldAddQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount + 1);
    }

    @Test
    public void shouldRemoveQuestion() {
        int beforeCount = questionService.getAll().size();

        assertThat(questionService.remove(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isNotIn(questionService.getAll());

        assertThat(questionService.getAll()).hasSize(beforeCount - 1);
    }

    @Test
    public void shouldThrowQuestionNotFoundExceprion() {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("INCORRECT", "INCORRECT")));
    }

    @Test
    public void shouldReturnAllQuestion() {
        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3
                );
    }

    @Test
    public void shouldReturnRandomQuestion() {
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.getAll());
    }
}