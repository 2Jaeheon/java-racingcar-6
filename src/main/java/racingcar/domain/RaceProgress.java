package racingcar.domain;

import java.util.List;

public record RaceProgress(List<CarStatus> cars) {
    // validate를 수행
    public RaceProgress {
        if (cars == null) {
            throw new IllegalArgumentException("진행 상태 목록은 null일 수 없습니다.");
        }
        // 불변 리스트를 고정
        cars = List.copyOf(cars);
    }
}
