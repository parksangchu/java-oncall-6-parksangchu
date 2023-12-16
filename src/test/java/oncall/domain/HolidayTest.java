package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class HolidayTest {

    @Test
    void isHoliday() {
        LocalDate localDate = LocalDate.of(2023, 10, 3);
        assertThat(Holiday.isHoliday(localDate)).isTrue();
    }
}