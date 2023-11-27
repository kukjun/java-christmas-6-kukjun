package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.discount.calendar.WeekendDiscountCalendar;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class WeekendDiscount implements DiscountImpl {
    private final int day;
    private final List<OrderImpl> orders;

    public WeekendDiscount(int day, List<OrderImpl> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        int discountSum = 0;
        for (OrderImpl order : orders) {
            if (order.isEligibleForDiscount() && order.getMenuItemCategory().equals(WEEKEND_DISCOUNT_CATEGORY)) {
                discountSum += WEEKEND_DEFAULT_DISCOUNT * order.getCount();
            }
        }
        return discountSum;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        boolean isDiscountCategory = false;
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
            if (order.getMenuItemCategory().equals(WEEKEND_DISCOUNT_CATEGORY)) {
                isDiscountCategory = true;
            }
        }
        if (sum >= WEEKEND_MINIMUM_EVENT_DISCOUNT_PRICE && WeekendDiscountCalendar.isDiscountDay(day) && isDiscountCategory) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "주말 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
