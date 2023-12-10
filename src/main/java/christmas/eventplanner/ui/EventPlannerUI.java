package christmas.eventplanner.ui;

import christmas.eventplanner.badge.Badge;
import christmas.eventplanner.discount.Discount;
import christmas.eventplanner.order.Order;

import java.util.List;
import java.util.Map;

public interface EventPlannerUI {
    void showEventPlanner();

    void requireRestaurantVisitDay();

    int inputRestaurantVisitDay();

    void requireOrderAndCounts();

    Map<String, Integer> inputOrderAndCounts();

    void showPreviewEvent(int day);

    void showOrderMenu(List<Order> orders);

    void showOrderPriceBeforeDiscount(int orderPrice);

    void showGifts(Order order);

    void showBenefits(List<Discount> discountList);

    void showSumBenefits(int sum);

    void showPaymentAmountAfterDiscount(int payment);

    void showEventBadge(Badge badge);


}
