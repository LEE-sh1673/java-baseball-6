package baseball.model;

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
}
