package baseball.model;

public class PlayResult {

    private static final int NUMBER_OF_BALL = 3;

    private int numberOfNothing;

    public PlayResult() {
        this.numberOfNothing = 0;
    }

    public boolean isNothing() {
        return numberOfNothing == NUMBER_OF_BALL;
    }

    public void add(final CompareResult compare) {
        if (compare.isNothing()) {
            numberOfNothing++;
        }
    }
}
