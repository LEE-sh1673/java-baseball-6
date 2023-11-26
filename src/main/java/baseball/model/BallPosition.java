package baseball.model;

import java.util.Objects;

public class BallPosition {

    private final int position;

    private BallPosition(final int position) {
        this.position = position;
    }

    public static BallPosition of(final int position) {
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
