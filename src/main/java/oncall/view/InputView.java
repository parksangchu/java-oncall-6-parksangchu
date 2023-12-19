package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.util.Util;
import oncall.util.Validator;

public class InputView {
    private static final String ASK_DAYS = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String ASK_WEEKDAY_EMPLOYEES = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String ASK_WEEKEND_EMPLOYEES = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

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

    public List<String> readWeekdayEmployees() {
        System.out.print(ASK_WEEKDAY_EMPLOYEES);
        String input = Console.readLine();
        return Util.splitByComma(input);
    }

    public List<String> readWeekendEmployees() {
        System.out.print(ASK_WEEKEND_EMPLOYEES);
        String input = Console.readLine();
        return Util.splitByComma(input);
    }
}
