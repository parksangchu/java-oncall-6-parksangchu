package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;

class WorkDaysTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new WorkDays("13,월")).isInstanceOf(IllegalArgumentException.class);
        WorkDays workDays = new WorkDays("6,화");
        List<LocalDate> localDateList = workDays.getLocalDates();
        localDateList.stream()
                .map(LocalDate::getDayOfMonth)
                .forEach(System.out::println);
    }

}