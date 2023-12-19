package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class AnniversaryTest {

    @Test
    void isHoliday() {
        LocalDate localDate = LocalDate.of(2023, 10, 3);
        assertThat(Anniversary.isAnniversary(localDate)).isTrue();
    }
}