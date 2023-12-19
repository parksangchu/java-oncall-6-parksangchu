package oncall.util;

import java.util.List;
import oncall.domain.Employee;

public class Validator {
    private static final String PATTERN_REGEX = "^[0-9]+,[가-힣]+$";

    public static void validateRange(int number, int min, int max) {
        if (number < min || number > max) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }
    }

    public static void validateDuplicated(List<Employee> employees) {
        if (employees.stream()
                .distinct()
                .count() != employees.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED.getMessage());
        }
    }

    public static void validateRegex(String input) {
        if (!input.matches(PATTERN_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PATTERN.getMessage());
        }
    }
}
