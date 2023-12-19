package oncall;

import oncall.controller.Controller;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Controller controller = new Controller(InputView.getInstance(), OutputView.getInstance());
        controller.start();
    }
}
