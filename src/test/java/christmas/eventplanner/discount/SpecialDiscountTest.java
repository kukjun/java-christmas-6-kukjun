package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.constant.MenuItem;
import christmas.eventplanner.util.constant.discount.DiscountConstants;
import christmas.eventplanner.util.constant.discount.calendar.SpecialDayDiscountCalendar;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SpecialDiscountTest {

    @Test
    void 할인_함수_실행시_Special_Discount_할인조건에_따라_할인해준다() {
        // given
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        orders.add(new OrderImpl(MenuItem.RED_WINE, 5, true));

        int day = SpecialDayDiscountCalendar.DAY_17.getDiscountDay();

        int expectedDiscount = DiscountConstants.SPECIAL_DEFAULT_DISCOUNT;

        // when
        Discount discount = new SpecialDiscount(day, orders);
        int resultDiscount = discount.discount();

        // then
        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }

    @Test
    void 총_주문금액이_10000원_이하이면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.ZERO_COLA, 2, true));
        int day = 1;

        boolean expectedIsBenefit = false;

        // when
        Discount discount = new SpecialDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간이_아니면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = 28;

        boolean expectedIsBenefit = false;

        // when
        Discount discount = new SpecialDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간에_총_주문금액이_10000원_이상이면_할인조건확인_함수가_true값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = SpecialDayDiscountCalendar.DAY_24.getDiscountDay();

        boolean expectedIsBenefit = true;

        // when
        Discount discount = new SpecialDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

}