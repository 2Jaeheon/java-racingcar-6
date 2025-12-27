package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.CarName;
import racingcar.domain.TryCount;

public class Parser {
    private Parser() {
    }

    public static List<CarName> parseCarNames(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        String[] split = input.split(",");
        List<CarName> names = new ArrayList<>();

        for (String raw : split) {
            names.add(new CarName(raw));
        }

        return names;
    }

    public static TryCount parseTryCount(String input) {
        return new TryCount(input);
    }
}
