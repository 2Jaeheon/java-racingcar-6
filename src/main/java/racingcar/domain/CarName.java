package racingcar.domain;

public class CarName {
    private final String value;

    // Validate를 생성자에서 수정 -> Validator없어짐
    public CarName(String raw) {
        String v = raw;
        if (v == null) {
            v = "";
        }
        v = v.trim();

        if (v.isEmpty() || v.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자여야 합니다.");
        }

        this.value = v;
    }

    public String value() {
        return value;
    }
}
