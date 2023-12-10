package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import java.util.List;

public class GiftDiscount implements Discount {


    private final List<Order> orders;

    public static final int MINIMUM_GIFT_DISCOUNT_PRICE = 120000;
    public static final int DEFAULT_DISCOUNT = 25000;


    public GiftDiscount(List<Order> orders) {
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
        if (sum >= MINIMUM_GIFT_DISCOUNT_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "증정 이벤트: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

}
