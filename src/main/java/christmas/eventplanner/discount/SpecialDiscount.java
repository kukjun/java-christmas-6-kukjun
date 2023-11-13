package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecialDiscount implements DiscountImpl {

    private static final Set<Integer> SPECIAL_DISCOUNT_DAYS = new HashSet<>(Arrays.asList(3, 10, 17, 24, 25, 31));
    private static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    private static final int DEFAULT_DISCOUNT = 1000;
    private final int day;

    private final List<OrderImpl> orders;

    public SpecialDiscount(int day, List<OrderImpl> orders) {
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
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && SPECIAL_DISCOUNT_DAYS.contains(day)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "특별 할인: -" + discount();
    }
}
