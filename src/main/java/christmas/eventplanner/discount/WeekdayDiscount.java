package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.discount.calendar.WeekdayDiscountCalendar;
import java.util.List;

public class WeekdayDiscount implements Discount {

    public static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    public static final String DISCOUNT_CATEGORY = "디저트";
    public static final int DEFAULT_DISCOUNT = 2023;
    private final int day;
    private final List<Order> orders;

    public WeekdayDiscount(int day, List<Order> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        int discountSum = 0;
        for (Order order : orders) {
            if (order.isEligibleForDiscount() && order.getMenuItemCategory().equals(DISCOUNT_CATEGORY)) {
                discountSum += DEFAULT_DISCOUNT * order.getCount();
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
            if (order.getMenuItemCategory().equals(DISCOUNT_CATEGORY)) {
                isDiscountCategory = true;
            }
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && WeekdayDiscountCalendar.isDiscountDay(day) && isDiscountCategory) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "평일 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

}
