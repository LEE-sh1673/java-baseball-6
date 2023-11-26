package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("야구 숫자의 개수가 3개가 아니면 예외가 발생한다.")
    @Test
    void givenExceededNumberOfBall_Then_ExceptionOccurs() {
        assertThatThrownBy(() -> Balls.byNumbers(List.of(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 숫자가 존재하지 않으면 낫싱이다.")
    @Test
    void givenBalls_WithDifferentNumbers_Then_NOTHING() {
        // given
        Balls computer = Balls.byNumbers(List.of(4, 2, 5));
        Balls player = Balls.byNumbers(List.of(7, 8, 9));

        // when
        PlayResult playResult = computer.compare(player);

        // then
        assertThat(playResult.isNothing()).isTrue();
    }
}
