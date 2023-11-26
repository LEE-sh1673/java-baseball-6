package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallPositionTest {

    @DisplayName("야구 숫자의 위치가 1부터 3까지의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void givenPositionOutOfRange_Then_ExceptionOccurs(final int position) {
        assertThatThrownBy(() -> BallPosition.of(position))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
