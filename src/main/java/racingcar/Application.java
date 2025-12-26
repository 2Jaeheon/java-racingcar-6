package racingcar;

import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.domain.RandomMoveStrategy;
import racingcar.util.Parser;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        Controller controller = new Controller(moveStrategy, race);

        controller.play();
    }
}
