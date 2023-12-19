package oncall.view;

import java.util.List;
import oncall.domain.Allocation;

public class OutputView {
    private static final String RESULT_FORMAT = "%d월 %d일 %s %s\n";
    private static final String RESULT_FORMAT_IF_WEEKDAY_HOLIDAY = "%d월 %d일 %s(휴일) %s\n";

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
            if (allocation.isWeekdayHoliday()) {
                System.out.printf(RESULT_FORMAT_IF_WEEKDAY_HOLIDAY, month, day, dayOfWeek, nickName);
                continue;
            }
            System.out.printf(RESULT_FORMAT, month, day, dayOfWeek, nickName);
        }
    }
}
