package christmas.eventplanner.discount;

import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.util.constant.MenuItem;
import christmas.eventplanner.util.constant.discount.DiscountConstants;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.List;


class DDayDiscountTest {

    @Test
    void 할인_함수_실행시_DDAY_할인조건에_따라_할인해준다() {
        // given
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = DiscountConstants.D_DAY_EVENT_START_DAY;

        int expectedDiscount = DiscountConstants.D_DAY_DEFAULT_DISCOUNT + DiscountConstants.D_DAY_DISCOUNT_UNIT * day;

        // when
        DiscountImpl discount = new DDayDiscount(day, orders);
        int resultDiscount = discount.discount();

        // then
        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }

    @Test
    void 총_주문금액이_10000원_이하이면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.ZERO_COLA, 2, true));
        int day = DiscountConstants.D_DAY_EVENT_START_DAY;

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new DDayDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간이_아니면_할인조건확인_함수가_false값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = DiscountConstants.D_DAY_EVENT_END_DAY + 3;

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new DDayDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 할인기간에_총_주문금액이_10000원_이상이면_할인조건확인_함수가_true값을_가진다() {
        List<Order> orders = new LinkedList<>();
        orders.add(new OrderImpl(MenuItem.CHOCOLATE_CAKE, 2, true));
        int day = 23;

        boolean expectedIsBenefit = true;

        // when
        DiscountImpl discount = new DDayDiscount(day, orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

}