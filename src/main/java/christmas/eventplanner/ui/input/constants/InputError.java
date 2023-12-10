package christmas.eventplanner.ui.input.constants;

public enum InputError {

    INVALID_SELECT_DAY("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_FOUND_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    COUNT_BIGGER_THEN_ONE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_MISMATCHING("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_OVERLAP("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_ONLY_DRINK("[ERROR] 음료만 주문한 경우 주문할 수 없습니다. 다시 입력해 주세요."),
    EXCEED_ORDER_COUNTS("[ERROR] 주문의 총 개수가 20개를 초과합니다. 다시 입력해 주세요."),
    ;


    private final String errorMessage;

    InputError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
