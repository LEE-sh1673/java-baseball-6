package baseball.model;

public enum CompareResult {
    STRIKE, BALL, NOTHING;

    public boolean isNothing() {
        return this == NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
