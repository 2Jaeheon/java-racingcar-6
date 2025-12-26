package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {

    public void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> calculateWinners(List<Car> cars) {
        int maxPosition = calculateMaxPosition(cars);
        return extractWinnersFrom(cars, maxPosition);
    }

    private int calculateMaxPosition(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            int position = car.calculatePosition();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }

    private List<String> extractWinnersFrom(List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.calculatePosition() == maxPosition) {
                winners.add(car.calculateName());
            }
        }
        return winners;
    }
}
