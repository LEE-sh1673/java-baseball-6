package baseball.view;

import baseball.model.PlayResult;
import java.util.StringJoiner;

public class OutputView {

    private static final String STRIKE_FORMAT = "%d스트라이크";
    private static final String BALL_FORMAT = "%d볼";

    private static final String RESULT_NOTHING = "낫싱";
    private static final String RESULT_ALL_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final int COUNT_ZERO = 0;

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private OutputView() {
        throw new AssertionError();
    }

    public static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printPlayResult(final PlayResult playResult) {
        final StringJoiner message = new StringJoiner(" ");

        if (playResult.isNothing()) {
            System.out.println(RESULT_NOTHING);
            return;
        }
        formatBall(message, playResult);
        formatStrike(message, playResult);
        System.out.println(message.toString().trim());
    }

    private static void formatBall(
            final StringJoiner message,
            final PlayResult playResult
    ) {
        if (playResult.numberOfBalls() != COUNT_ZERO) {
            message.add(String.format(BALL_FORMAT, playResult.numberOfBalls()));
        }
    }

    private static void formatStrike(
            final StringJoiner message,
            final PlayResult playResult
    ) {
        if (playResult.numberOfStrikes() != 0) {
            message.add(String.format(STRIKE_FORMAT, playResult.numberOfStrikes()));
        }
        if (playResult.isAllStrike()) {
            message.add(System.lineSeparator())
                    .add(RESULT_ALL_STRIKE);
        }
    }
}
