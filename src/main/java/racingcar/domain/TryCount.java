package racingcar.domain;

public class TryCount {
    private final int value;

    // Validate를 생성자에서 수정 -> Validator없어짐
    public TryCount(String raw) {
        String s = "";
        if (raw != null) {
            s = raw.trim();
        }

        if (s.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        try {
            int v = Integer.parseInt(s);
            if (v < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
            }
            this.value = v;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
    }

    public int value() {
        return value;
    }
}
