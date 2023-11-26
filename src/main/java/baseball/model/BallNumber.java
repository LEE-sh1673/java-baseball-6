package baseball.model;

import static baseball.model.BallAttribute.MAX_BALL_NUMBER;
import static baseball.model.BallAttribute.MIN_BALL_NUMBER;

import java.util.Objects;

public class BallNumber {

    private final int number;

    private BallNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    static BallNumber of(final int number) {
        return new BallNumber(number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BallNumber other = (BallNumber) o;
        return number == other.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
