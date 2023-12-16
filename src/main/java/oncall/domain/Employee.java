package oncall.domain;

import java.util.Objects;
import oncall.util.Validator;

public class Employee {
    private static final int MIN_NICKNAME_RANGE = 1;
    private static final int MAX_NICKNAME_RANGE = 5;
    private final String nickname;

    public Employee(String nickname) {
        validateRange(nickname);
        this.nickname = nickname;
    }

    private void validateRange(String nickname) {
        Validator.validateRange(nickname.length(), MIN_NICKNAME_RANGE, MAX_NICKNAME_RANGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee employee)) {
            return false;
        }
        return Objects.equals(nickname, employee.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname);
    }
}
