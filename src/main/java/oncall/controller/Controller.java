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
        AllocationGroup allocationGroup = createAllocationGroup(workDays);
        outputView.printResult(allocationGroup.getAllocations());
    }

    private AllocationGroup createAllocationGroup(WorkDays workDays) {
        while (true) {
            try {
                EmployeeGroup employeeGroup = createEmployeeGroup();
                AllocationService allocationService = new AllocationService(workDays, employeeGroup);
                return allocationService.allocate();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
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

    private EmployeeGroup createEmployeeGroup() {
        while (true) {
            try {
                List<Employee> weekdayEmployees = inputView.readWeekdayEmployees()
                        .stream()
                        .map(Employee::new)
                        .collect(Collectors.toList());
                List<Employee> weekendEmployees = inputView.readWeekendEmployees()
                        .stream()
                        .map(Employee::new)
                        .collect(Collectors.toList());
                return new EmployeeGroup(weekdayEmployees, weekendEmployees);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}