package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private final MoveStrategy moveStrategy;


    public Car(MoveStrategy moveStrategy, String name) {
        this.moveStrategy = moveStrategy;
        this.position = 0;
        this.name = name;
    }

    public void move() {
        if (moveStrategy.isMovable()) {
            position++;
        }
    }

    public int calculatePosition() {
        return position;
    }

    public String calculateName() {
        return name;
    }
}
