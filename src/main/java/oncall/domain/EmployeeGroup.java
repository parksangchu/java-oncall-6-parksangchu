package oncall.domain;

import java.util.List;
import oncall.util.Validator;

public class EmployeeGroup {
    private static final int MIN_EMPLOYEES_SIZE = 5;
    private static final int MAX_EMPLOYEES_SIZE = 35;
    private final List<Employee> employees;

    public EmployeeGroup(List<Employee> employees) {
        validateDuplicated(employees);
        validateRange(employees);
        this.employees = employees;
    }

    private void validateDuplicated(List<Employee> employees) {
        Validator.validateDuplicated(employees);
    }

    private void validateRange(List<Employee> employees) {
        Validator.validateRange(employees.size(), MIN_EMPLOYEES_SIZE, MAX_EMPLOYEES_SIZE);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
