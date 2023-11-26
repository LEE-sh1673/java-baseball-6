package baseball.view;

import baseball.model.GameOption;
import baseball.model.Player;
import baseball.validator.NumericValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String INPUT_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";

    private static final String INPUT_GAME_OPTION_NUMBER
            = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String NUMBER_SPLITTER = "";

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private InputView() {
        throw new AssertionError();
    }

    public static Player readPlayer() {
        System.out.print(INPUT_PLAYER_NUMBERS);
        return new Player(readNumbers());
    }

    private static List<Integer> readNumbers() {
        final String strNumber = Console.readLine();
        final List<String> splitNumbers = Arrays.asList(strNumber.split(NUMBER_SPLITTER));

        splitNumbers.forEach(NumericValidator::validate);

        return splitNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    public static GameOption readGameOption() {
        System.out.println(INPUT_GAME_OPTION_NUMBER);
        return GameOption.findByNumber(readNumber());
    }

    private static int readNumber() {
        final String strNumber = Console.readLine();
        NumericValidator.validate(strNumber);
        return Integer.parseInt(strNumber);
    }
}
