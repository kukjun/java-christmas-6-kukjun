package christmas.eventplanner.ui;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.discount.DiscountImpl;
import christmas.eventplanner.order.OrderImpl;

import java.util.List;
import java.util.Map;

public interface EventPlannerUI {
    void showEventPlanner();

    void requireRestaurantVisitDay();

    int inputRestaurantVisitDay();

    void requireOrderAndCounts();

    Map<String, Integer> inputOrderAndCounts();

    void showPreviewEvent(int day);

    void showOrderMenu(List<OrderImpl> orders);

    void showOrderPriceBeforeDiscount(int orderPrice);

    void showGifts(OrderImpl order);

    void showBenefits(List<DiscountImpl> discountList);

    void showSumBenefits(int sum);

    void showPaymentAmountAfterDiscount(int payment);

    void showEventBadge(BadgeImpl badge);


}
