package baseball.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @DisplayName("야구 숫자에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void givenDuplicatedNumbers_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> Balls.byNumbers(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
