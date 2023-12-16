package oncall.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Allocation {
    private final LocalDate localDate;
    private final Employee employee;

    public Allocation(LocalDate localDate, Employee employee) {
        this.localDate = localDate;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return localDate.format(DateTimeFormatter.ofPattern("M D일 E ")) + employee.getNickname();
    }
}
