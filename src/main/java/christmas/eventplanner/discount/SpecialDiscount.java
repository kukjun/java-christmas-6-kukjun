package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.discount.calendar.SpecialDayDiscountCalendar;
import java.util.List;

public class SpecialDiscount implements Discount {

    public static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    public static final int DEFAULT_DISCOUNT = 1000;

    private final int day;

    private final List<Order> orders;

    public SpecialDiscount(int day, List<Order> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        return DEFAULT_DISCOUNT;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && SpecialDayDiscountCalendar.isDiscountDay(day)) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "특별 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

}
