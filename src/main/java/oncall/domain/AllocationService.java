package oncall.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllocationService {
    private final WorkDays workDays;
    private final EmployeeGroup weekdayGroup;
    private final EmployeeGroup weekendGroup;

    public AllocationService(WorkDays workDays, EmployeeGroup weekdayGroup, EmployeeGroup weekendGroup) {
        this.workDays = workDays;
        this.weekdayGroup = weekdayGroup;
        this.weekendGroup = weekendGroup;
    }

    public AllocationGroup allocate() {
        List<Allocation> allocations = new ArrayList<>();
        List<Employee> weekdayEmployees = new ArrayList<>(weekdayGroup.getEmployees());
        List<Employee> weekendEmployees = new ArrayList<>(weekendGroup.getEmployees());
        for (LocalDate localDate : workDays.getLocalDates()) {
            if (weekdayEmployees.isEmpty()) {
                weekdayEmployees = new ArrayList<>(weekdayGroup.getEmployees());
            }
            if (weekendEmployees.isEmpty()) {
                weekendEmployees = new ArrayList<>(weekdayGroup.getEmployees());
            }
            Allocation allocation = createAllocation(localDate, weekdayEmployees, weekendEmployees);
            allocations.add(allocation);
        }
        return new AllocationGroup(allocations);
    }

    private Allocation createAllocation(
            LocalDate localDate, List<Employee> weekdayEmployees, List<Employee> weekendEmployees) {
        if (!isHoliday(localDate)) {
            return new Allocation(localDate, weekdayEmployees.remove(0));
        }
        return new Allocation(localDate, weekendEmployees.remove(0));
    }

    private boolean isWeekend(LocalDate localDate) {
        return localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY;
    }

    private boolean isHoliday(LocalDate localDate) {
        return isWeekend(localDate) || Anniversary.isAnniversary(localDate);
    }
}
