package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeekdayDiscount implements DiscountImpl {
    private static final Set<Integer> WEEKDAY_DISCOUNT_DAYS =
            new HashSet<>(Arrays.asList(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31));
    private static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    private static final String DISCOUNT_CATEGORY = "디저트";
    private static final int DEFAULT_DISCOUNT = 2023;
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
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
            if (order.getMenuItemCategory().equals(DISCOUNT_CATEGORY)) {
                isDiscountCategory = true;
            }
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && WEEKDAY_DISCOUNT_DAYS.contains(day) && isDiscountCategory) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "평일 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
