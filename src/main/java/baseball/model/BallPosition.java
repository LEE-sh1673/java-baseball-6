package baseball.model;

import java.util.Objects;

public class BallPosition {

    private static final int MIN = 1;
    private static final int MAX = 3;

    private final int position;

    private BallPosition(final int position) {
        validate(position);
        this.position = position;
    }

    private void validate(final int position) {
        if (position < MIN || position > MAX) {
            throw new IllegalArgumentException();
        }
    }

    static BallPosition of(final int position) {
        return new BallPosition(position);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BallPosition other = (BallPosition) o;
        return position == other.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
