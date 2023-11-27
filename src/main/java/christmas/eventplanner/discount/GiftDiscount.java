package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class GiftDiscount implements DiscountImpl {


    private final List<OrderImpl> orders;

    public GiftDiscount(List<OrderImpl> orders) {
        this.orders = orders;
    }

    @Override
    public int discount() {
        return GIFT_DEFAULT_DISCOUNT;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= GIFT_MINIMUM_GIFT_DISCOUNT_PRICE) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "증정 이벤트: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
