package tw.core.generator;

import org.junit.jupiter.api.Test;
import tw.core.Answer;
import tw.core.exception.AnswerFormatIncorrectException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



        import org.junit.jupiter.api.Test;
        import tw.core.Answer;
        import tw.core.exception.AnswerFormatIncorrectException;

        import static org.hamcrest.MatcherAssert.assertThat;
        import static org.hamcrest.core.Is.is;
        import static org.hamcrest.core.IsNull.notNullValue;
        import static org.junit.jupiter.api.Assertions.assertThrows;
        import static org.junit.jupiter.api.Assertions.fail;
        import static org.mockito.ArgumentMatchers.anyInt;
        import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.when;

/**
 * Created by jxzhong on 2017/5/17.
 */
public class RandomIntGeneratorTest {

    @Test
    public void generateNums_wrong_input_test() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();

        try{
            randomIntGenerator.generateNums( 3,4);
            fail("Can't ask for more numbers than are available");
        }catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void generateNums_right_input_test() throws Exception {
        RandomIntGenerator randomIntGenerator = new RandomIntGenerator();

        try{
            randomIntGenerator.generateNums( 3,2);
        }catch (IllegalArgumentException e) {
            fail("Can't ask for more numbers than are available");
        }
    }


}
