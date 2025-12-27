package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.domain.CarStatus;
import racingcar.domain.RaceProgress;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(RaceProgress progress) {
        for (CarStatus s : progress.cars()) {
            System.out.println(s.name() + " : " + "-".repeat(s.position()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
