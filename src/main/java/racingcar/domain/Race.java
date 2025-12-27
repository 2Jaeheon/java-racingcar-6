package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;

    public Race(Cars cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.moveAll();
    }

    public RaceProgress progress() {
        return cars.progressSnapshot();
    }

    public List<String> winners() {
        return cars.winnerNames();
    }
}
