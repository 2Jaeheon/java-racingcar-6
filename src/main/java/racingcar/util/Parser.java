package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseCarNames(String carNames) {
        validateCarNames(carNames);

        String[] splitCars = carNames.split(",");
        return new ArrayList<>(Arrays.asList(splitCars));
    }

    public static int parseTryCount(String tryCount) {
        int number;

        try {
            number = Integer.parseInt(tryCount);
        } catch (Error e) {
            throw new IllegalArgumentException();
        }

        return number;
    }

    private static void validateCarNames(String carNames) {
        String[] eachCar = carNames.split(",");
        
        for (String name : eachCar) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }

            if (!isAlphabet(name)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean isAlphabet(String name) {
        String lowerCarName = name.toLowerCase();

        for (int i = 0; i < lowerCarName.length(); i++) {
            if (lowerCarName.charAt(i) < 'a' || lowerCarName.charAt(i) > 'z') {
                return false;
            }
        }

        return true;
    }


}
