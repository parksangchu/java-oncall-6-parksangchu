package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AllocationServiceTest {

    @Test
    void allocate() {
        WorkDays workDays = new WorkDays("5,월");
        EmployeeGroup weekdayGroup = createWeekdayGroup();
        EmployeeGroup weekendGroup = createWeekendGroup();
        AllocationService allocationService = new AllocationService(workDays, weekdayGroup, weekendGroup);
        AllocationGroup allocationGroup = allocationService.allocate();
        allocationGroup.getAllocations()
                .forEach(allocation -> System.out.println(allocation.toString()));

    }

    EmployeeGroup createWeekdayGroup() {
        List<Employee> weekdayEmployees = new ArrayList<>();
        weekdayEmployees.add(new Employee("상추"));
        weekdayEmployees.add(new Employee("뭉이"));
        weekdayEmployees.add(new Employee("금실이"));
        weekdayEmployees.add(new Employee("루니"));
        weekdayEmployees.add(new Employee("감자"));
        return new EmployeeGroup(weekdayEmployees);
    }

    EmployeeGroup createWeekendGroup() {
        List<Employee> weekendEmployees = new ArrayList<>();
        weekendEmployees.add(new Employee("뭉이"));
        weekendEmployees.add(new Employee("상추"));
        weekendEmployees.add(new Employee("금실이"));
        weekendEmployees.add(new Employee("감자"));
        weekendEmployees.add(new Employee("루니"));
        return new EmployeeGroup(weekendEmployees);
    }
}