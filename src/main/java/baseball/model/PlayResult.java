package baseball.model;

import static baseball.model.BallAttribute.NUMBER_OF_BALLS;

public class PlayResult {

    private int numberOfBalls;

    private int numberOfStrike;

    private int numberOfNothing;

    PlayResult() {
        this.numberOfBalls = 0;
        this.numberOfStrike = 0;
        this.numberOfNothing = 0;
    }

    void add(final CompareResult compare) {
        if (compare.isNothing()) {
            numberOfNothing++;
        }
        if (compare.isStrike()) {
            numberOfStrike++;
        }
        if (compare.isBall()) {
            numberOfBalls++;
        }
    }

    public boolean isNothing() {
        return numberOfNothing == NUMBER_OF_BALLS;
    }

    public boolean isAllStrike() {
        return numberOfStrike == NUMBER_OF_BALLS;
    }

    public int numberOfBalls() {
        return numberOfBalls;
    }

    public int numberOfStrikes() {
        return numberOfStrike;
    }
}
