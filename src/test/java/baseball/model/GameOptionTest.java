package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameOptionTest {

    @DisplayName("재시작/종료를 구분하는 숫자가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 3})
    void givenInvalidOptionNumber_Then_ExceptionOccurs(final int optionNumber) {
        assertThatThrownBy(() -> GameOption.findByNumber(optionNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
