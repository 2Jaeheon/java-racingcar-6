package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;
import racingcar.domain.TryCount;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final MoveStrategy moveStrategy;

    public Controller(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void play() {
        // init
        OutputView.printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<CarName> names = Parser.parseCarNames(InputView.readCarNames());
        OutputView.printMessage("시도할 회수는 몇회인가요?");
        TryCount tryCount = Parser.parseTryCount(InputView.readTryCount());

        // ready
        Cars cars = createCars(names);
        Race race = new Race(cars);

        // play
        OutputView.printMessage("실행 결과");
        playRace(tryCount, race);

        // result
        OutputView.printWinners(race.winners());
    }

    private void playRace(TryCount tryCount, Race race) {
        for (int i = 0; i < tryCount.value(); i++) {
            race.playRound();
            OutputView.printRoundResult(race.progress());
        }
    }

    private Cars createCars(List<CarName> names) {
        List<Car> cars = new ArrayList<>();
        for (CarName name : names) {
            cars.add(new Car(name, moveStrategy));
        }
        return new Cars(cars);
    }
}
