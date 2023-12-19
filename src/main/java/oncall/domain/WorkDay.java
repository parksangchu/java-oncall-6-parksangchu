package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class WorkDay {
    private final LocalDate localDate;
    private final DayOfWeek dayOfWeek;
    private final boolean isHoliday;

    public WorkDay(LocalDate localDate) {
        this.localDate = localDate;
        this.dayOfWeek = localDate.getDayOfWeek();
        this.isHoliday = isHoliday();
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

    public String getDayOfWeekName() {
        return WorkDayOfWeek.StringOf(localDate.getDayOfWeek());
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }

    public int getMonth() {
        return localDate.getMonthValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WorkDay workDay)) {
            return false;
        }
        return isHoliday == workDay.isHoliday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isHoliday);
    }
}
