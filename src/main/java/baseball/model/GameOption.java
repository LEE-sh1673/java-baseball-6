package baseball.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public enum GameOption {
    RESTART(1),
    QUIT(2);

    private static final Map<Integer, GameOption> numberToOption = Arrays.stream(values())
            .collect(Collectors.toMap(
                    gameOption -> gameOption.optionNumber,
                    gameOption -> gameOption
            ));

    private final int optionNumber;

    GameOption(final int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static GameOption findByNumber(final int optionNumber) {
        return Optional.ofNullable(numberToOption.get(optionNumber))
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
