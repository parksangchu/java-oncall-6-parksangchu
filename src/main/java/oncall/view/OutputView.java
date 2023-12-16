package oncall.view;

public class OutputView {
    private static final String GAME_START = "게임을 시작합니다";

    private static final OutputView instance = new OutputView();

    public static OutputView getInstance(){
        return instance;
    }
    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
