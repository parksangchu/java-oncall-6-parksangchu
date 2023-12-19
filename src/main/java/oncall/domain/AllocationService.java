package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class AllocationService {
    private final WorkDays workDays;
    private final EmployeeGroup employeeGroup;

    public AllocationService(WorkDays workDays, EmployeeGroup employeeGroup) {
        this.workDays = workDays;
        this.employeeGroup = employeeGroup;
    }

    public AllocationGroup allocate() {
        List<Allocation> allocations = new ArrayList<>();
        List<Employee> weekdayEmployees = new ArrayList<>();
        List<Employee> weekendEmployees = new ArrayList<>();
        for (WorkDay workDay : workDays.getWorkDays()) {
            if (weekdayEmployees.isEmpty()) {
                weekdayEmployees = new ArrayList<>(employeeGroup.getWeekdayEmployees());
            }
            if (weekendEmployees.isEmpty()) {
                weekendEmployees = new ArrayList<>(employeeGroup.getWeekendEmployees());
            }
            Allocation allocation = createAllocation(workDay, weekdayEmployees, weekendEmployees);
            allocations.add(allocation);
        }
        return new AllocationGroup(allocations);
    }

    private Allocation createAllocation(WorkDay workDay, List<Employee> weekdayEmployees,
                                        List<Employee> weekendEmployees) {
        if (workDay.isHoliday()) {
            return new Allocation(workDay, weekendEmployees.remove(0));
        }
        return new Allocation(workDay, weekdayEmployees.remove(0));
    }
}
