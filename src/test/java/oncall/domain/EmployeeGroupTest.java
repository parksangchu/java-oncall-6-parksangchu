package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EmployeeGroupTest {
    @Test
    void create() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            Employee employee = new Employee("상추" + i);
            employees.add(employee);
        }
        assertThatThrownBy(() -> new EmployeeGroup(employees)).isInstanceOf(IllegalArgumentException.class);
    }
}