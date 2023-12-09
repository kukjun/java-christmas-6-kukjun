package christmas.eventplanner.ui.output;

import christmas.eventplanner.badge.Badge;
import christmas.eventplanner.discount.Discount;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.ui.output.OutputMessage;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    public void showEventPlanner() {
        System.out.println(OutputMessage.START_EVENT_PLANNER.getMessage());
    }

    public void requireRestaurantVisitDay() {
        System.out.println(OutputMessage.REQUIRE_VISIT_DAY.getMessage());
    }

    public void requireOrderAndCounts() {
        System.out.println(OutputMessage.REQUIRE_ORDER_COUNT.getMessage());
    }

    public void showPreviewEvent(int day) {
        System.out.println(OutputMessage.PREVIEW_EVENT.getFormattedMessage(day));
        System.out.println();
    }

    public void showOrderMenu(List<Order> orders) {
        System.out.println(OutputMessage.ORDER_MENU_TITLE.getMessage());
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        System.out.println();
    }

    public void showOrderPriceBeforeDiscount(int orderPrice) {
        System.out.println(OutputMessage.ORDER_PRICE_BEFORE_DISCOUNT.getMessage());
        System.out.println(NumberFormatter.formatNumber(orderPrice) + OutputMessage.ONE.getMessage());
        System.out.println();
    }

    public void showGifts(Order order) {
        System.out.println(OutputMessage.GIFT_MENU_TITLE.getMessage());
        System.out.println(order.show());
        System.out.println();
    }

    public void showBenefits(List<Discount> discountList) {
        System.out.println(OutputMessage.BENEFITS_TITLE.getMessage());
        if(discountList.isEmpty()) {
            System.out.println(OutputMessage.NO_BENEFITS.getMessage());
            System.out.println();
            return;
        }
        for (Discount discount : discountList) {
            System.out.println(discount.show());
        }
        System.out.println();
    }

    public void showSumBenefits(int sum) {
        System.out.println(OutputMessage.SUM_BENEFITS_TITLE.getMessage());
        System.out.println(OutputMessage.MINUS.getMessage() + NumberFormatter.formatNumber(sum) + OutputMessage.ONE.getMessage());
        System.out.println();
    }

    public void showPaymentAmountAfterDiscount(int payment) {
        System.out.println(OutputMessage.PAYMENT_AMOUNT_AFTER_DISCOUNT.getMessage());
        System.out.println(NumberFormatter.formatNumber(payment) + OutputMessage.ONE.getMessage());
        System.out.println();
    }

    public void showEventBadge(Badge badge) {
        System.out.println(OutputMessage.EVENT_BADGE_TITLE.getMessage());
        System.out.println(badge.show());
        System.out.println();
    }
}
