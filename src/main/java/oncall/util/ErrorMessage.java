package oncall.util;

public enum ErrorMessage {

    INVALID_OUT_OF_INT_RANGE("입력 범위를 초과하였습니다."),
    DUPLICATED("입력에 중복 값이 존재합니다."),
    INVALID_PATTERN("올바르지 않은 입력형식입니다."),
    INVALID_DAY_OF_WEEK("옳지않은 요일입니다."),
    INVALID_GROUP("평일 근무자와 동일하지 않습니다."),
    INVALID_CHANGE("대체 근무자를 찾을 수 없습니다.");


    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message, Object... replaces) {
        this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
    }

    public String getMessage() {
        return message;
    }
}