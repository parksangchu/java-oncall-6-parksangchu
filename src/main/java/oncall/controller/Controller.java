package oncall.controller;

import java.util.List;
import java.util.stream.Collectors;
import oncall.domain.AllocationGroup;
import oncall.domain.AllocationService;
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
        EmployeeGroup weekdayGroup = createWeekdayGroup();
        EmployeeGroup weekendGroup = createWeekendGroup();
        AllocationService allocationService = new AllocationService(workDays, weekdayGroup, weekendGroup);
        AllocationGroup allocationGroup = allocationService.allocate();
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

    private EmployeeGroup createWeekdayGroup() {
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

    private EmployeeGroup createWeekendGroup() {
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