package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.util.Validator;

public class InputView {
    private static final String ASK_DAYS = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";

    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public String readDays() {
        System.out.print(ASK_DAYS);
        String input = Console.readLine();
        Validator.validateRegex(input);
        return input;
    }
}
