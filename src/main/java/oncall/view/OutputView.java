package oncall.view;

import java.util.List;
import oncall.domain.Allocation;

public class OutputView {
    private static final String RESULT_FORMAT = "%d월 %d일 %s %s\n";

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printResult(List<Allocation> allocations) {
        System.out.println();
        for (Allocation allocation : allocations) {
            int month = allocation.getMonth();
            int day = allocation.getDay();
            String dayOfWeek = allocation.getDayOfWeekName();
            String nickName = allocation.getNickName();
            System.out.printf(RESULT_FORMAT, month, day, dayOfWeek, nickName);
        }
    }
}
