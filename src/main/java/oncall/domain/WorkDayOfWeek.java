package oncall.domain;

import java.time.DayOfWeek;
import java.util.Arrays;
import oncall.util.ErrorMessage;

public enum WorkDayOfWeek {
    MONDAY(DayOfWeek.MONDAY, "월"),
    TUESDAY(DayOfWeek.TUESDAY, "화"),
    WEDNESDAY(DayOfWeek.WEDNESDAY, "수"),
    THURSDAY(DayOfWeek.THURSDAY, "목"),
    FRIDAY(DayOfWeek.FRIDAY, "금"),
    SATURDAY(DayOfWeek.SATURDAY, "토"),
    SUNDAY(DayOfWeek.SUNDAY, "일");

    private final DayOfWeek dayOfWeek;
    private final String name;

    WorkDayOfWeek(DayOfWeek dayOfWeek, String name) {
        this.dayOfWeek = dayOfWeek;
        this.name = name;
    }

    public static DayOfWeek of(String name) {
        WorkDayOfWeek workDayOfWeek = Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DAY_OF_WEEK.getMessage()));
        return workDayOfWeek.dayOfWeek;
    }
}
