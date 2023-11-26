package baseball.model;

import static baseball.model.BallAttribute.NUMBER_OF_BALLS;

public class PlayResult {

    private int numberOfNothing;

    PlayResult() {
        this.numberOfNothing = 0;
    }

    public boolean isNothing() {
        return numberOfNothing == NUMBER_OF_BALLS;
    }

    void add(final CompareResult compare) {
        if (compare.isNothing()) {
            numberOfNothing++;
        }
    }
}
