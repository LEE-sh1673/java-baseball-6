package baseball.model;

import static baseball.model.BallAttribute.MAX_BALL_NUMBER;
import static baseball.model.BallAttribute.MIN_BALL_NUMBER;
import static baseball.model.BallAttribute.NUMBER_OF_BALLS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Stream;

public class RandomBallsGenerator implements BallsGenerator {

    @Override
    public Balls generate() {
        return Balls.byNumbers(makeBallNumbers());
    }

    private List<Integer> makeBallNumbers() {
        return Stream.generate(this::pickRandomNumber)
                .distinct()
                .limit(NUMBER_OF_BALLS)
                .toList();
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
    }
}
