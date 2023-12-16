package oncall.view;

public class InputView {
    private static final String ASK_MAIN_OPTION = "메인 옵션";

    private static final InputView instance = new InputView();

    public static InputView getInstance(){
        return instance;
    }
    private InputView() {
    }

    public String readMainOption() {
        System.out.println(ASK_MAIN_OPTION);
        String input = Console.readLine();
        return input;
    }
}
