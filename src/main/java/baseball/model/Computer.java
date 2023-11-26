package baseball.model;

public class Computer {

    private final Balls balls;

    public Computer(final BallsGenerator ballsGenerator) {
        balls = ballsGenerator.generate();
    }

    PlayResult compute(final Balls playerBalls) {
        return balls.compare(playerBalls);
    }
}
