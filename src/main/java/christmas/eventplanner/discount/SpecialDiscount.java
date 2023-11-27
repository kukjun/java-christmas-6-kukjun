package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.NumberFormatter;
import christmas.eventplanner.util.constant.discount.calendar.SpecialDayDiscountCalendar;

import java.util.List;

import static christmas.eventplanner.util.constant.discount.DiscountConstants.SPECIAL_DEFAULT_DISCOUNT;
import static christmas.eventplanner.util.constant.discount.DiscountConstants.SPECIAL_MINIMUM_EVENT_DISCOUNT_PRICE;

public class SpecialDiscount implements DiscountImpl {

    private final int day;

    private final List<OrderImpl> orders;

    public SpecialDiscount(int day, List<OrderImpl> orders) {
        this.day = day;
        this.orders = orders;
    }

    @Override
    public int discount() {
        return SPECIAL_DEFAULT_DISCOUNT;
    }

    @Override
    public boolean isBenefit() {
        int sum = 0;
        for (OrderImpl order : orders) {
            sum += order.getOrderPrice();
        }
        if (sum >= SPECIAL_MINIMUM_EVENT_DISCOUNT_PRICE && SpecialDayDiscountCalendar.isDiscountDay(day)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "특별 할인: -" + NumberFormatter.formatNumber(discount()) + "원";
    }
}
