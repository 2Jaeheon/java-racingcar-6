package racingcar.domain;

public class Car {
    private final CarName name;
    private int position;
    private final MoveStrategy moveStrategy;


    public Car(CarName name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    // Tell, Don't Ask 원칙 적용
    public boolean isAheadOf(Car other) {
        return this.position > other.position;
    }

    public boolean isTiedWith(Car other) {
        return this.position == other.position;
    }

    // CarStatus DTO로 감싸서 정보를 전달
    public CarStatus status() {
        return new CarStatus(name.value(), position);
    }

    // Cars 중복 검사에서만 사용
    public String nameValue() {
        return name.value();
    }
}
