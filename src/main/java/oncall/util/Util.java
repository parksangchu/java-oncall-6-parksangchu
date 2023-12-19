package oncall.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]";
    private static final String COMMA = ",";
    private static final String BAR = " | ";

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }
    public static String convertToString(List<String> strings){
        return strings.stream()
                .collect(Collectors.joining(BAR, PREFIX, SUFFIX));
    }
    private Util() {
    }
}
