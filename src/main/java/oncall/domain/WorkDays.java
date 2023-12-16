package oncall.domain;

import static oncall.domain.Constants.THIS_YEAR;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import oncall.util.Util;
import oncall.util.Validator;

public class WorkDays {
    private static final int FEBRUARY = 2;
    private static final int LAST_DAY_OF_FEBRUARY = 28;
    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;
    private final List<LocalDate> localDates;

    public WorkDays(String input) {
        List<String> separatedInput = Util.splitByComma(input);
        int month = getMonth(separatedInput);
        DayOfWeek dayOfWeek = getDayOfWeek(separatedInput);
        this.localDates = getWorkDays(month, dayOfWeek);
    }

    private List<LocalDate> getWorkDays(int month, DayOfWeek dayOfWeek) {
        int startDay = getStartDay(month, dayOfWeek);
        if (month == FEBRUARY) {
            return IntStream.rangeClosed(startDay, LAST_DAY_OF_FEBRUARY)
                    .mapToObj(day -> LocalDate.of(THIS_YEAR.getNumber(), month, day))
                    .collect(Collectors.toList());
        }
        int lastDay = getLastDay(month, startDay);
        return IntStream.rangeClosed(startDay, lastDay)
                .mapToObj(day -> LocalDate.of(THIS_YEAR.getNumber(), month, day))
                .collect(Collectors.toList());
    }

    private int getStartDay(int month, DayOfWeek dayOfWeek) {
        int day = 0;
        for (int i = 1; i <= 7; i++) {
            LocalDate localDate = LocalDate.of(THIS_YEAR.getNumber(), month, i);
            if (localDate.getDayOfWeek() == dayOfWeek) {
                day = i;
                break;
            }
        }
        return day;
    }

    private int getLastDay(int month, int day) {
        LocalDate startDate = LocalDate.of(THIS_YEAR.getNumber(), month, day);
        LocalDate lastDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return lastDate.getDayOfMonth();
    }

    private int getMonth(List<String> separatedInput) {
        int month = Integer.parseInt(separatedInput.get(0));
        Validator.validateRange(month, MIN_MONTH, MAX_MONTH);
        return month;
    }

    private DayOfWeek getDayOfWeek(List<String> separatedInput) {
        return WorkDayOfWeek.of(separatedInput.get(1));
    }

    public List<LocalDate> getLocalDates() {
        return localDates;
    }
}
