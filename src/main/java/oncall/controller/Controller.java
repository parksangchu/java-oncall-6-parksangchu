package oncall.controller;

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
    }

    private WorkDays createWorkDays() {
        while (true) {
            try {
                String input = inputView.readDays();
                return new WorkDays(input);
            } catch (Exception e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}