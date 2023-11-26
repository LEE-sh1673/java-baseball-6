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

        CompareResult result = computer.compare(player);
        assertThat(result).isEqualTo(CompareResult.NOTHING);
    }
}
