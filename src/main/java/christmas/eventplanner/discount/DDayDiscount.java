package christmas.eventplanner.discount;


import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.*;

public class DDayDiscount implements Discount {

    private final List<Order> orders;
    private final int day;

    public DDayDiscount(int day, List<Order> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        return D_DAY_DEFAULT_DISCOUNT + day * D_DAY_DISCOUNT_UNIT;
    }

    // 없음을 뜨게 하는건 혜택 내역의 열할
    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (Order order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= D_DAY_MINIMUM_EVENT_DISCOUNT_PRICE && day >= D_DAY_EVENT_START_DAY && day <= D_DAY_EVENT_END_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "크리스마스 디데이 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }

    @Override
    public String toString() {
        return "크리스마스 디데이 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
