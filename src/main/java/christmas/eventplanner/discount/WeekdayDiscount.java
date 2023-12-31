package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.discount.calendar.WeekdayDiscountCalendar;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class WeekdayDiscount implements DiscountImpl {
    private final int day;
    private final List<OrderImpl> orders;

    public WeekdayDiscount(int day, List<OrderImpl> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        int discountSum = 0;
        for (OrderImpl order : orders) {
            if (order.isEligibleForDiscount() && order.getMenuItemCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                discountSum += WEEKDAY_DEFAULT_DISCOUNT * order.getCount();
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
            if (order.getMenuItemCategory().equals(WEEKDAY_DISCOUNT_CATEGORY)) {
                isDiscountCategory = true;
            }
        }
        if (sum >= WEEKDAY_MINIMUM_EVENT_DISCOUNT_PRICE && WeekdayDiscountCalendar.isDiscountDay(day) && isDiscountCategory) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "평일 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
