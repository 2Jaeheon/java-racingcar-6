package racingcar;

import racingcar.domain.RandomMoveStrategy;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new RandomMoveStrategy());
        controller.play();
    }
}
