package oncall.domain;

import java.time.LocalDate;

public class Allocation {
    private final LocalDate localDate;
    private final Employee employee;

    public Allocation(LocalDate localDate, Employee employee) {
        this.localDate = localDate;
        this.employee = employee;
    }
}
