package christmas.eventplanner.discount;


import christmas.eventplanner.order.OrderImpl;

import java.util.List;

public class DDayDiscount implements DiscountImpl {
    private static final int D_DAY_EVENT_START_DAY = 1;
    private static final int D_DAY_EVENT_END_DAY = 25;
    private static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    private static final int DEFAULT_DISCOUNT = 900;
    private static final int DISCOUNT_UNIT = 100;

    private final List<OrderImpl> orders;
    private final int day;

    public DDayDiscount(int day, List<OrderImpl> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        return DEFAULT_DISCOUNT + day * DISCOUNT_UNIT;
    }

    // 없음을 뜨게 하는건 혜택 내역의 열할
    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && day >= D_DAY_EVENT_START_DAY && day <= D_DAY_EVENT_END_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "크라스마스 디데이 할인: -" + discount();
    }
}
