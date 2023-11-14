package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;

import java.util.List;

public class GiftDiscount implements DiscountImpl {

    private static final int MINIMUM_GIFT_DISCOUNT_PRICE = 120000;
    private static final int DEFAULT_DISCOUNT = 25000;

    private final List<OrderImpl> orders;

    public GiftDiscount(List<OrderImpl> orders) {
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
        if (sum >= MINIMUM_GIFT_DISCOUNT_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "증정 이벤트: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
