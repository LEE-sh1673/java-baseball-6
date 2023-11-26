package baseball.model;

import static baseball.model.CompareResult.BALL;
import static baseball.model.CompareResult.NOTHING;
import static baseball.model.CompareResult.STRIKE;

import java.util.Objects;

public class Ball {

    private final BallNumber number;

    private final BallPosition position;

    Ball(final BallNumber number, final BallPosition position) {
        this.number = number;
        this.position = position;
    }

    CompareResult compare(final Ball other) {
        if (equals(other)) {
            return STRIKE;
        }
        if (matchNumber(other)) {
            return BALL;
        }
        return NOTHING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Ball other = (Ball) o;
        return matchNumber(other) && matchPosition(other);
    }

    private boolean matchNumber(final Ball other) {
        return number.equals(other.number);
    }

    private boolean matchPosition(final Ball other) {
        return position.equals(other.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
