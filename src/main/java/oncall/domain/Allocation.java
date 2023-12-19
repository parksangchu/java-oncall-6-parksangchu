package oncall.domain;

import java.util.Objects;

public class Allocation {
    private final WorkDay workDay;
    private Employee employee;

    public Allocation(WorkDay workDay, Employee employee) {
        this.workDay = workDay;
        this.employee = employee;
    }

    public String getNickName() {
        return employee.getNickname();
    }

    public String getDayOfWeekName() {
        return workDay.getDayOfWeekName();
    }

    public int getDay() {
        return workDay.getDay();
    }

    public int getMonth() {
        return workDay.getMonth();
    }

    public boolean isWeekdayHoliday() {
        return workDay.isWeekdayHoliday();
    }

    public void changeEmployee(Allocation allocation) {
        Employee tmp = this.employee;
        this.employee = allocation.employee;
        allocation.employee = tmp;
    }


    public boolean isEqualWorkdayGroup(Allocation allocation) {
        return this.workDay.equals(allocation.workDay);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Allocation that)) {
            return false;
        }
        return Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee);
    }
}
