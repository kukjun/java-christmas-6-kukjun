package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeekendDiscount implements DiscountImpl {
    private static final Set<Integer> WEEKEND_DISCOUNT_DAYS =
            new HashSet<>(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30));
    private static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    private static final String DISCOUNT_CATEGORY = "메인";
    private static final int DEFAULT_DISCOUNT = 2023;
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
            if (order.isEligibleForDiscount() && order.getMenuItemCategory().equals(DISCOUNT_CATEGORY)) {
                discountSum += DEFAULT_DISCOUNT;
            }
        }
        return discountSum;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && WEEKEND_DISCOUNT_DAYS.contains(day)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "주말 할인: -" + discount();
    }
}
