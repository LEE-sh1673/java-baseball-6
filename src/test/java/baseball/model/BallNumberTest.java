package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BallNumberTest {

    @DisplayName("야구 숫자가 1에서 9사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void givenNumberOutOfRange_Then_ExceptionOccurs(final int number) {
        assertThatThrownBy(() -> BallNumber.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
