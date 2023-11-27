package christmas.eventplanner.ui.output;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.discount.DiscountImpl;
import christmas.eventplanner.order.OrderImpl;

import java.util.List;

public interface OutputView {
    void showEventPlanner();
    void requireRestaurantVisitDay();

    void requireOrderAndCounts();

    void showPreviewEvent(int day);

    void showOrderMenu(List<OrderImpl> orders);

    void showOrderPriceBeforeDiscount(int orderPrice) ;

    void showGifts(OrderImpl order) ;

    void showBenefits(List<DiscountImpl> discountList) ;

    void showSumBenefits(int sum);

    void showPaymentAmountAfterDiscount(int payment);

    void showEventBadge(BadgeImpl badge);
}
