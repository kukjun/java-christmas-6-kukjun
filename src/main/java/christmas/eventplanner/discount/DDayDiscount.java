package christmas.eventplanner.discount;


import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.NumberFormatter;
import java.util.List;

public class DDayDiscount implements Discount {

    public static final int EVENT_START_DAY = 1;
    public static final int EVENT_END_DAY = 25;
    public static final int MINIMUM_EVENT_DISCOUNT_PRICE = 10000;
    public static final int DEFAULT_DISCOUNT = 900;
    public static final int DISCOUNT_UNIT = 100;
    private final List<Order> orders;
    private final int day;

    public DDayDiscount(int day, List<Order> orders) {
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
        for (Order order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= MINIMUM_EVENT_DISCOUNT_PRICE && day >= EVENT_START_DAY && day <= EVENT_END_DAY) {
            return true;
        }
        return false;
    }

    @Override
    public String show() {
        return "크리스마스 디데이 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
