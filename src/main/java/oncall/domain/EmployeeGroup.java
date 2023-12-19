package oncall.domain;

import java.util.Collections;
import java.util.List;
import oncall.util.ErrorMessage;
import oncall.util.Validator;

public class EmployeeGroup {
    private static final int MIN_EMPLOYEES_SIZE = 5;
    private static final int MAX_EMPLOYEES_SIZE = 35;
    private final List<Employee> weekdayEmployees;
    private final List<Employee> weekendEmployees;

    public EmployeeGroup(List<Employee> weekdayEmployees, List<Employee> weekendEmployees) {
        validateDuplicated(weekdayEmployees);
        validateDuplicated(weekendEmployees);
        validateRange(weekdayEmployees);
        validateRange(weekendEmployees);
        validateEqual(weekdayEmployees, weekendEmployees);
        this.weekdayEmployees = weekdayEmployees;
        this.weekendEmployees = weekendEmployees;
    }

    private void validateDuplicated(List<Employee> employees) {
        Validator.validateDuplicated(employees);
    }

    private void validateRange(List<Employee> employees) {
        Validator.validateRange(employees.size(), MIN_EMPLOYEES_SIZE, MAX_EMPLOYEES_SIZE);
    }

    public List<Employee> getWeekdayEmployees() {
        return Collections.unmodifiableList(weekdayEmployees);
    }

    public List<Employee> getWeekendEmployees() {
        return Collections.unmodifiableList(weekendEmployees);
    }

    public void validateEqual(List<Employee> weekdayEmployees, List<Employee> weekendEmployees) {
        if (weekendEmployees.stream()
                .anyMatch(employee -> !weekdayEmployees.contains(employee))) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_GROUP.getMessage());
        }
    }
}
