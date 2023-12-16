package oncall.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class EmployeeTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new Employee("뭉이이조아아")).isInstanceOf(IllegalArgumentException.class);
    }
}