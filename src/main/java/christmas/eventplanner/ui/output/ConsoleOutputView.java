package christmas.eventplanner.ui.output;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.discount.DiscountImpl;
import christmas.eventplanner.order.OrderImpl;

import java.util.List;

// TODO 숫자 10000 -> 10,000으로 변경 하는 방법 추후 적용
public class ConsoleOutputView implements OutputView {
    public void showEventPlanner() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void requireRestaurantVisitDay() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public void requireOrderAndCounts() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public void showPreviewEvent(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public void showOrderMenu(List<OrderImpl> orders) {
        System.out.println("<주문 메뉴>");
        for (OrderImpl order : orders) {
            System.out.println(order.toString());
        }
        System.out.println();
    }

    public void showOrderPriceBeforeDiscount(int orderPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(orderPrice + "원");
        System.out.println();
    }

    public void showGifts(OrderImpl order) {
        System.out.println("<증정 메뉴>");
        System.out.println(order.toString());
        System.out.println();
    }

    public void showBenefits(List<DiscountImpl> discountList) {
        System.out.println("<혜택 내역>");
        if(discountList.isEmpty()) {
            System.out.println("없음");
            System.out.println();
            return;
        }
        for (DiscountImpl discount : discountList) {
            System.out.println(discount.toString());
        }
        System.out.println();
    }

    public void showSumBenefits(int sum) {
        System.out.println("<총혜택 금액>");
        System.out.println(sum);
        System.out.println();
    }

    public void showPaymentAmountAfterDiscount(int payment) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(payment);
        System.out.println();
    }

    public void showEventBadge(BadgeImpl badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge.toString());
        System.out.println();
    }
}
