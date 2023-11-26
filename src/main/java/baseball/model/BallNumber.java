package baseball.model;

import java.util.Objects;

public class BallNumber {

    private static final int MIN = 1;
    private static final int MAX = 9;

    private final int number;

    private BallNumber(final int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException();
        }
    }

    public static BallNumber of(final int number) {
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
