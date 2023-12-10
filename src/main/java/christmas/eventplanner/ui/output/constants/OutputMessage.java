package christmas.eventplanner.ui.output.constants;

public enum OutputMessage {
    START_EVENT_PLANNER("이벤트 플래너 시작!"),
    REQUIRE_VISIT_DAY("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    REQUIRE_ORDER_COUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW_EVENT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU_TITLE("<주문 메뉴>"),
    ORDER_PRICE_BEFORE_DISCOUNT("<할인 전 총주문 금액>"),
    GIFT_MENU_TITLE("<증정 메뉴>"),
    BENEFITS_TITLE("<혜택 내역>"),
    NO_BENEFITS("없음"),
    SUM_BENEFITS_TITLE("<총혜택 금액>"),
    PAYMENT_AMOUNT_AFTER_DISCOUNT("<할인 후 예상 결제 금액>"),
    EVENT_BADGE_TITLE("<12월 이벤트 배지>"),
    ONE("원"),
    MINUS("-");
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }

}
