package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumericValidatorTest {

    @DisplayName("숫자 형식이 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"sdfjlvo14n", "121@fsh", "1,2,4", "-1,2,10.0"})
    void isNotNumeric_Then_ExceptionOccurs(final String stringNumber) {
        assertThatThrownBy(() -> NumericValidator.validate(stringNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 형식이면 예외가 발생하지 않는다.")
    @Test
    void isNumeric_Then_NoExceptionOccurs() {
        assertThatCode(() -> NumericValidator.validate("123"))
                .doesNotThrowAnyException();
    }
}
