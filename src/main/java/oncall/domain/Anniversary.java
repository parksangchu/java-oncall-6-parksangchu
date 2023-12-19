package oncall.domain;

import static oncall.domain.ThisYear.THIS_YEAR;

import java.time.LocalDate;
import java.util.Arrays;

public enum Anniversary {
    THE_NEW_YEAR(LocalDate.of(THIS_YEAR.getNumber(), 1, 1)),
    MARCH_ONE_DAY(LocalDate.of(THIS_YEAR.getNumber(), 3, 1)),
    CHILDREN_DAY(LocalDate.of(THIS_YEAR.getNumber(), 5, 5)),
    MEMORIAL_DAY(LocalDate.of(THIS_YEAR.getNumber(), 6, 6)),
    NATIONAL_LIBERATION_DAY(LocalDate.of(THIS_YEAR.getNumber(), 8, 15)),
    NATIONAL_FOUNDATION_DAY(LocalDate.of(THIS_YEAR.getNumber(), 10, 3)),
    HANGUL_DAY(LocalDate.of(THIS_YEAR.getNumber(), 10, 9)),
    CHRISTMAS(LocalDate.of(THIS_YEAR.getNumber(), 12, 25));
    private final LocalDate localDate;

    Anniversary(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static boolean isAnniversary(LocalDate localDate) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.localDate.equals(localDate));
    }

}
