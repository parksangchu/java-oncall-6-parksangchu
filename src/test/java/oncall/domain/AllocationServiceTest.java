package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AllocationServiceTest {

    @Test
    void allocate() {
        WorkDays workDays = new WorkDays("5,월");
        List<Employee> weekdayGroup = createWeekdayGroup();
        List<Employee> weekendGroup = createWeekendGroup();
        EmployeeGroup employeeGroup = new EmployeeGroup(weekdayGroup, weekendGroup);
        AllocationService allocationService = new AllocationService(workDays, employeeGroup);
        AllocationGroup allocationGroup = allocationService.allocate();
        allocationGroup.getAllocations()
                .forEach(allocation -> System.out.println(allocation.toString()));

    }

    List<Employee> createWeekdayGroup() {
        List<Employee> weekdayEmployees = new ArrayList<>();
        weekdayEmployees.add(new Employee("상추"));
        weekdayEmployees.add(new Employee("뭉이"));
        weekdayEmployees.add(new Employee("금실이"));
        weekdayEmployees.add(new Employee("루니"));
        weekdayEmployees.add(new Employee("감자"));
        return weekdayEmployees;
    }

    List<Employee> createWeekendGroup() {
        List<Employee> weekendEmployees = new ArrayList<>();
        weekendEmployees.add(new Employee("뭉이"));
        weekendEmployees.add(new Employee("상추"));
        weekendEmployees.add(new Employee("금실이"));
        weekendEmployees.add(new Employee("감자"));
        weekendEmployees.add(new Employee("루니"));
        return weekendEmployees;
    }
}