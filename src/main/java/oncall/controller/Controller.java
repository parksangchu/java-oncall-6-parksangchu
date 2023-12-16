package oncall.controller;

import java.util.List;
import java.util.stream.Collectors;
import oncall.domain.Employee;
import oncall.domain.EmployeeGroup;
import oncall.domain.WorkDays;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        WorkDays workDays = createWorkDays();
        EmployeeGroup weekdayEmployees = createWeekdayEmployees();
        EmployeeGroup weekendEmployees = createWeekendEmployees();
    }


    private WorkDays createWorkDays() {
        while (true) {
            try {
                String input = inputView.readDays();
                return new WorkDays(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private EmployeeGroup createWeekdayEmployees() {
        while (true) {
            try {
                List<String> input = inputView.readWeekdayEmployees();
                List<Employee> employees = input.stream()
                        .map(Employee::new)
                        .collect(Collectors.toList());
                return new EmployeeGroup(employees);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private EmployeeGroup createWeekendEmployees() {
        while (true) {
            try {
                List<String> input = inputView.readWeekdayEmployees();
                List<Employee> employees = input.stream()
                        .map(Employee::new)
                        .collect(Collectors.toList());
                return new EmployeeGroup(employees);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}