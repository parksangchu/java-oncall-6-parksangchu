package oncall.domain;

import java.time.LocalDate;

public class Allocation {
    private final LocalDate localDate;
    private Employee employee;

    public Allocation(LocalDate localDate, Employee employee) {
        this.localDate = localDate;
        this.employee = employee;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getNickName() {
        return employee.getNickname();
    }

    public String getDayOfWeekName() {
        return WorkDayOfWeek.StringOf(localDate.getDayOfWeek());
    }

    public void changeEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getDay() {
        return localDate.getDayOfMonth();
    }

    public int getMonth() {
        return localDate.getMonthValue();
    }

    public boolean is(Employee employee) {
        return this.employee.equals(employee);
    }
}
