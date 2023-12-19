package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WorkDay {
    private final LocalDate localDate;
    private final DayOfWeek dayOfWeek;

    public WorkDay(LocalDate localDate) {
        this.localDate = localDate;
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    public boolean isWeekend() {
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public boolean isHoliday() {
        return isWeekend() || Anniversary.isAnniversary(localDate);
    }

    public boolean isWeekdayHoliday() {
        return isWeekday() && Anniversary.isAnniversary(localDate);
    }
}
