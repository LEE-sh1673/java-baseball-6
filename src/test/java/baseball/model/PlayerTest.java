package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {

    private final Computer computer
            = new Computer(() -> Balls.byNumbers(List.of(4, 2, 5)));

    @DisplayName("컴퓨터 숫자와 플레이어 숫자가 주어졌을 때, 비교 결과를 구한다.")
    @ParameterizedTest
    @MethodSource("providePlayerNumbersWithPlayResult")
    void givenComputerNumbers_WithPlayerNumbers_PlayResultReturns(
            final List<Integer> playerNumbers,
            final int expectedStrikes,
            final int expectedBalls,
            final boolean isNothing
    ) {
        // given
        Player player = new Player(playerNumbers);

        // when
        PlayResult playResult = player.play(computer);

        // then
        assertThat(playResult.numberOfStrikes()).isEqualTo(expectedStrikes);
        assertThat(playResult.numberOfBalls()).isEqualTo(expectedBalls);
        assertThat(playResult.isNothing()).isEqualTo(isNothing);
    }

    private static Stream<Arguments> providePlayerNumbersWithPlayResult() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 1, 0, false),
                Arguments.of(List.of(4, 5, 6), 1, 1, false),
                Arguments.of(List.of(7, 8, 9), 0, 0, true)
        );
    }
}
