package racingcar;

import static racingcar.util.Parser.parseCarNames;
import static racingcar.util.Parser.parseTryCount;
import static racingcar.view.InputView.readCarNames;
import static racingcar.view.InputView.readTryCount;
import static racingcar.view.OutputView.printMessage;
import static racingcar.view.OutputView.printRoundResult;
import static racingcar.view.OutputView.printWinPlayers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Car;
import racingcar.domain.MoveStrategy;
import racingcar.domain.Race;

public class Controller {
    private final MoveStrategy moveStrategy;
    private final Race race;


    public Controller(MoveStrategy moveStrategy, Race race) {
        this.moveStrategy = moveStrategy;
        this.race = race;
    }

    public void play() {
        List<String> carNames = initCar();
        List<Car> cars = initCarList(carNames);
        int tryCount = initTryCount();

        playRace(tryCount, cars);
        printWinner(cars);
    }

    private void printWinner(List<Car> cars) {
        List<String> winners = race.calculateWinners(cars);
        printWinPlayers(winners);
    }

    private void playRace(int tryCount, List<Car> cars) {
        printMessage("실행 결과");

        for (int i = 0; i < tryCount; i++) {
            race.playRound(cars);
            printRoundResult(extractCarInfo(cars));
        }
    }

    private List<Car> initCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(moveStrategy, name);
            cars.add(car);
        }
        return cars;
    }

    private int initTryCount() {
        printMessage("시도할 회수는 몇회인가요?");
        String tryCountStr = readTryCount();
        int tryCount = parseTryCount(tryCountStr);
        return tryCount;
    }

    private List<String> initCar() {
        printMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = readCarNames();
        List<String> carNames = parseCarNames(input);
        return carNames;
    }

    private Map<String, Integer> extractCarInfo(List<Car> cars) {
        Map<String, Integer> carInfo = new LinkedHashMap<>();

        for (Car car : cars) {
            String name = car.calculateName();
            int position = car.calculatePosition();
            carInfo.put(name, position);
        }

        return carInfo;
    }
}
