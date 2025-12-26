package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean isMovable() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        return pickedNumber >= 4;
    }
}
