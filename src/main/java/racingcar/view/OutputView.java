package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printRoundResult(Map<String, Integer> raceProgress) {
        for (var e : raceProgress.entrySet()) {
            System.out.println(e.getKey() + " : " + "-".repeat(e.getValue()));
        }
        System.out.println();
    }

    public static void printWinPlayers(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
