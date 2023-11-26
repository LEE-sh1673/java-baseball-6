package baseball.model;

public enum CompareResult {
    STRIKE, BALL, NOTHING;

    boolean isNothing() {
        return this == NOTHING;
    }

    boolean isStrike() {
        return this == STRIKE;
    }

    boolean isBall() {
        return this == BALL;
    }
}
