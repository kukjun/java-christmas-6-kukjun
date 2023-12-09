package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.constant.MenuItem;
import christmas.eventplanner.util.constant.discount.DiscountConstants;
import christmas.eventplanner.util.constant.discount.calendar.WeekendDiscountCalendar;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeekendDiscountTest {
    @Test
    void 할인_함수_실행시_Weekday_Discount_할인조건에_따라_할인해준다() {
        // given
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        orders.add(new OrderImpl(MenuItem.RED_WINE, 3, true));
        orders.add(new OrderImpl(MenuItem.T_BONE_STEAK, 2, true));

        int day = WeekendDiscountCalendar.DAY_9.getDiscountDay();

        int expectedDiscount = DiscountConstants.WEEKEND_DEFAULT_DISCOUNT * 2;

        // when
        DiscountImpl discount = new WeekendDiscount(day, orders);
        int resultDiscount = discount.discount();

        // then
        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }

    @Test
    void 총_주문금액이_10000원_이하이면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.ZERO_COLA, 2, true));
        int day = WeekendDiscountCalendar.DAY_9.getDiscountDay();

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new WeekendDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간이_아니면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = 24;

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new WeekendDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간에_총_주문금액이_10000원_이상이어도_할인_카테고리_음식이_없으면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.RED_WINE, 2, true));
        int day = WeekendDiscountCalendar.DAY_9.getDiscountDay();

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new WeekendDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간에_총_주문금액이_10000원_이상면서_할인_카테고리_음식이_있으면_할인조건확인_함수가_true값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        orders.add(new OrderImpl(MenuItem.T_BONE_STEAK, 2, true));

        int day = WeekendDiscountCalendar.DAY_9.getDiscountDay();

        boolean expectedIsBenefit = true;

        // when
        DiscountImpl discount = new WeekendDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }
}