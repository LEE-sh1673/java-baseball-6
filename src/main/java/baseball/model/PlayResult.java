package baseball.model;

import static baseball.model.BallAttribute.NUMBER_OF_BALLS;

public class PlayResult {

    private int numberOfNothing;

    private int numberOfStrike;

    PlayResult() {
        this.numberOfNothing = 0;
    }

    public boolean isNothing() {
        return numberOfNothing == NUMBER_OF_BALLS;
    }

    public boolean isAllStrike() {
        return numberOfStrike == NUMBER_OF_BALLS;
    }

    public int numberOfStrikes() {
        return numberOfStrike;
    }

    void add(final CompareResult compare) {
        if (compare.isNothing()) {
            numberOfNothing++;
        }
        if (compare.isStrike()) {
            numberOfStrike++;
        }
    }
}
