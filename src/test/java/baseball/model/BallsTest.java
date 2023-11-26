package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallsTest {

    private final Balls computer = Balls.byNumbers(List.of(4, 2, 5));

    @DisplayName("야구공에 중복된 야구 숫자가 있으면 예외가 발생한다.")
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
        PlayResult playResult = computer.compare(Balls.byNumbers(List.of(7, 8, 9)));
        assertThat(playResult.isNothing()).isTrue();
    }

    @DisplayName("두 야구공의 모든 숫자가 서로 같고, 같은 자리에 있으면 3 스트라이크이다.")
    @Test
    void givenBalls_WithAllSameNumbers_Then_STRIKE() {
        PlayResult playResult = computer.compare(Balls.byNumbers(List.of(4, 2, 5)));
        assertThat(playResult.isAllStrike()).isTrue();
    }

    @DisplayName("두 야구공을 비교하여 스트라이크의 개수를 구한다.")
    @ParameterizedTest
    @MethodSource("providePlayBallsWithNumberOfStrikes")
    void givenComputerBalls_WithPlayBallNumbers_Then_NumberOfStrikesReturns(
            final List<Integer> playerNumbers,
            final int expectedNumberOfStrikes
    ) {
        PlayResult playResult = computer.compare(Balls.byNumbers(playerNumbers));
        assertThat(playResult.numberOfStrikes()).isEqualTo(expectedNumberOfStrikes);
    }

    private static Stream<Arguments> providePlayBallsWithNumberOfStrikes() {
        return Stream.of(
                Arguments.of(List.of(4, 2, 5), 3),
                Arguments.of(List.of(1, 2, 3), 1),
                Arguments.of(List.of(1, 2, 5), 2)
        );
    }
}
