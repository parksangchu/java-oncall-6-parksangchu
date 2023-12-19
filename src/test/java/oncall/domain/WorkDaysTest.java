package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class WorkDaysTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new WorkDays("13,월")).isInstanceOf(IllegalArgumentException.class);
        WorkDays workDays = new WorkDays("5,월");
        List<WorkDay> workdays = workDays.getWorkDays();
        workdays.stream()
                .map(workDay -> workDay.getDay())
                .forEach(System.out::println);
    }

}