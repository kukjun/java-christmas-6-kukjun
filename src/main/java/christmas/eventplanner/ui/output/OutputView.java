package christmas.eventplanner.ui.output;

import christmas.eventplanner.badge.Badge;
import christmas.eventplanner.discount.Discount;
import christmas.eventplanner.order.Order;

import java.util.List;

public interface OutputView {
    void showEventPlanner();
    void requireRestaurantVisitDay();

    void requireOrderAndCounts();

    void showPreviewEvent(int day);

    void showOrderMenu(List<Order> orders);

    void showOrderPriceBeforeDiscount(int orderPrice) ;

    void showGifts(Order order) ;

    void showBenefits(List<Discount> discountList) ;

    void showSumBenefits(int sum);

    void showPaymentAmountAfterDiscount(int payment);

    void showEventBadge(Badge badge);
}
