package baseball.model;

public class BallPosition {

    private final int position;

    private BallPosition(final int position) {
        this.position = position;
    }

    public static BallPosition of(final int position) {
        return new BallPosition(position);
    }
}
