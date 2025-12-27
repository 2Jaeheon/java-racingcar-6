package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 전체 자동차에 관한 행동을 책임짐
// 자동차 컬렉션에 대한 책임
public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = List.copyOf(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    // 각 레이스의 진행상황을 스냅샷찍어서 DTO로 전달
    public RaceProgress progressSnapshot() {
        List<CarStatus> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(car.status());
        }
        return new RaceProgress(statuses);
    }

    public List<String> winnerNames() {
        Car leader = findLeader();
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isTiedWith(leader)) {
                winners.add(car.nameValue());
            }
        }

        return winners;
    }

    private Car findLeader() {
        Car leader = cars.get(0);
        for (Car car : cars) {
            if (car.isAheadOf(leader)) {
                leader = car;
            }
        }
        return leader;
    }

    private void validate(List<Car> cars) {
        // 자동차 개수
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("자동차는 1대 이상이어야 합니다.");
        }

        // null 방지
        for (Car car : cars) {
            if (car == null) {
                throw new IllegalArgumentException("자동차 목록에 null이 포함될 수 없습니다.");
            }
        }

        // 중복
        Set<String> names = new HashSet<>();
        for (Car car : cars) {
            if (!names.add(car.nameValue())) {
                throw new IllegalArgumentException("자동차 이름이 중복되었습니다: " + car.nameValue());
            }
        }
    }
}
