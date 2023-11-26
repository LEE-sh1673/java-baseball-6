package baseball.model;

import static baseball.model.CompareResult.NOTHING;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Balls {

    private static final int BALL_NUMBER = 3;

    private final List<Ball> balls;

    private Balls(final List<Integer> numbers) {
        validateDuplicate(numbers);
        validateSize(numbers);
        this.balls = makeBallNumbers(numbers);
    }

    private void validateDuplicate(final List<Integer> numbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != BALL_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private List<Ball> makeBallNumbers(final List<Integer> numbers) {
        return IntStream.range(0, numbers.size())
                .mapToObj((idx) -> makeBall(numbers, idx))
                .toList();
    }

    private Ball makeBall(final List<Integer> numbers, final int index) {
        return new Ball(BallNumber.of(numbers.get(index)), BallPosition.of(index + 1));
    }

    static Balls byNumbers(final List<Integer> numbers) {
        return new Balls(numbers);
    }

    PlayResult compare(final Balls other) {
        final PlayResult playResult = new PlayResult();

        for (final Ball ball : balls) {
            playResult.add(other.compare(ball));
        }
        return playResult;
    }

    private CompareResult compare(final Ball other) {
        return balls.stream()
                .map(ball -> ball.compare(other))
                .filter(CompareResult::isNothing)
                .findFirst()
                .orElse(NOTHING);
    }
}
