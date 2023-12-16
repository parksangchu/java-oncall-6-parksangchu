package oncall.util;

import java.util.List;

public class Validator {
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public static void validateNumeric(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }

    public void validateRange(String input, int min, int max) {
        int number = Integer.parseInt(input);
        if (number < min || number > max){
            throw new IllegalArgumentException(ErrorMessage.INVALID_OUT_OF_INT_RANGE.getMessage());
        }
    }
    public void validateDuplicated(List<String> strings){
        if(strings.stream()
                .distinct()
                .count() != strings.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED.getMessage());
        }
    }
}
