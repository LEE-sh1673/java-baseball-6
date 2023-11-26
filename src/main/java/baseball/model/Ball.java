package baseball.model;

public class Ball {

    private final BallNumber number;

    private final BallPosition position;

    public Ball(final BallNumber number, final BallPosition position) {
        this.number = number;
        this.position = position;
    }

    public CompareResult compare(final Ball other) {
        return CompareResult.NOTHING;
    }
}
