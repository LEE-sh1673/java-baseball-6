package baseball.controller;

import baseball.model.BallsGenerator;
import baseball.model.Computer;
import baseball.model.GameOption;
import baseball.model.PlayResult;
import baseball.model.Player;
import baseball.model.RandomBallsGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public void run() {
        OutputView.printGameStartMessage();
        playGame();
    }

    private void playGame() {
        final Computer computer = createComputer();
        process(computer);
        askForRestart();
    }

    private Computer createComputer() {
        return new Computer(getBallsGenerator());
    }

    private BallsGenerator getBallsGenerator() {
        return new RandomBallsGenerator();
    }

    private void process(final Computer computer) {
        final Player player = InputView.readPlayer();
        final PlayResult playResult = player.play(computer);

        OutputView.printPlayResult(playResult);

        if (!playResult.isAllStrike()) {
            process(computer);
        }
    }

    private void askForRestart() {
        final GameOption option = InputView.readGameOption();

        if (option.isRestart()) {
            playGame();
        }
    }
}
