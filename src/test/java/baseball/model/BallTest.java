package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallTest {

    @DisplayName("같은 수가 전혀 없으면 낫싱이다.")
    @Test
    void givenDifferentNumbers_Then_NOTHING() {
        Ball computer = new Ball(BallNumber.of(4), BallPosition.of(0));
        Ball player = new Ball(BallNumber.of(1), BallPosition.of(0));
        assertThat(computer.compare(player)).isEqualTo(CompareResult.NOTHING);
    }

    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크이다.")
    @Test
    void givenSameNumbersInSamePosition_Then_NOTHING() {
        Ball computer = new Ball(BallNumber.of(1), BallPosition.of(0));
        Ball player = new Ball(BallNumber.of(1), BallPosition.of(0));
        assertThat(computer.compare(player)).isEqualTo(CompareResult.STRIKE);
    }

    @DisplayName("같은 수가 다른 자리에 있으면 볼이다.")
    @Test
    void givenSameNumbersInDifferentPosition_Then_BALL() {
        Ball computer = new Ball(BallNumber.of(1), BallPosition.of(0));
        Ball player = new Ball(BallNumber.of(1), BallPosition.of(2));
        assertThat(computer.compare(player)).isEqualTo(CompareResult.BALL);
    }
}
