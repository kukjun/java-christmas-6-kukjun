package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.discount.calendar.SpecialDayDiscountCalendar;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.SPECIAL_DEFAULT_DISCOUNT;
import static christmas.eventplanner.util.constant.discount.DiscountConstants.SPECIAL_MINIMUM_EVENT_DISCOUNT_PRICE;

public class SpecialDiscount implements Discount {

    private final int day;

    private final List<Order> orders;

    public SpecialDiscount(int day, List<Order> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        return SPECIAL_DEFAULT_DISCOUNT;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= SPECIAL_MINIMUM_EVENT_DISCOUNT_PRICE && SpecialDayDiscountCalendar.isDiscountDay(day)) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "특별 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

    @Override
    public String toString() {
        return "특별 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
