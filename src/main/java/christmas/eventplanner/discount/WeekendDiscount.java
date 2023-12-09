package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.discount.calendar.WeekendDiscountCalendar;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class WeekendDiscount implements Discount {
    private final int day;
    private final List<Order> orders;

    public WeekendDiscount(int day, List<Order> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        int discountSum = 0;
        for (Order order : orders) {
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
        for (Order order : orders) {
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
    public String show() {
        return "주말 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

}
