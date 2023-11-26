package baseball.model;

import java.util.List;

public class Player {

    private final Balls balls;

    public Player(final List<Integer> numbers) {
        this.balls = Balls.byNumbers(numbers);
    }

    public PlayResult play(final Computer computer) {
        return computer.compute(balls);
    }
}
