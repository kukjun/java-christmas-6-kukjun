package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class GiftDiscount implements Discount {


    private final List<Order> orders;

    public GiftDiscount(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public int discount() {
        return GIFT_DEFAULT_DISCOUNT;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= GIFT_MINIMUM_GIFT_DISCOUNT_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "증정 이벤트: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

    @Override
    public String toString() {
        return "증정 이벤트: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
