package tw.core;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tw.core.exception.AnswerFormatIncorrectException;
import tw.core.model.Record;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static tw.core.Answer.createAnswer;

/**
 * Created by jxzhong on 2017/9/23.
 */
public class AnswerTest {
    private Answer actualAnswer;

    @BeforeEach
    public void setUp() {
        actualAnswer = createAnswer("1 2 3 4");
    }
    @Test
    public void toString_test(){
       String array = "1 2 3 4";
        assertThat(actualAnswer.toString(), is(array));
//        String array="1 2 3 4";
//        List<String> inputList = Arrays.stream(new String[]{array}).collect(Collectors.toList());
//        assertThat(actualAnswer, is(inputList));
    }
//
//    @Test
//    public void validate_test(){
//       String array = "2 3 4 5";
//
//        Answer answer=createAnswer("2 3 4 5");
//        assertThat(answer.toString(), is(array));
//    }

    @Test
    public void validate_test_wrong_input(){
        Answer answer=createAnswer("2 2 3 3");
        try {
            answer.validate();
            fail("Answer format is incorrect");
        } catch (AnswerFormatIncorrectException e) {

        }
    }
    @Test
    public void validate_test_right_input(){
        Answer answer=createAnswer("3 4 5 6");
        try {
            answer.validate();
        } catch (AnswerFormatIncorrectException e) {
            fail("Answer format is incorrect");
        }
    }
    @Test
    public void getIndexOfNum_input(){
        Answer answer=createAnswer("1 2 3 4");
        assertThat( answer.getIndexOfNum("3"), is(2));
    }
    @Test
    @SuppressWarnings("unchecked")
    void test_check() {
//        // mock creation
//        Record record = mock(Record.class);
//        // using mock object - it does not throw any "unexpected interaction" exception
//
//        // selective, explicit, highly readable verification
//        verify(record).increaseCurrentNum();
//        verify(record).increaseIncludeOnlyNum();
        Answer answer=createAnswer("1 2 3 4");
        Answer guessanswer=createAnswer("3 2 6 7");
        assertThat( (answer.check(guessanswer)).getValue(), is("1A1B"));
    }


}