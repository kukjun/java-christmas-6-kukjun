package christmas.eventplanner.discount;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.util.constant.MenuItem;
import christmas.eventplanner.util.constant.discount.DiscountConstants;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GiftDiscountTest {
    @Test
    void 할인_함수_실행시_Gift_할인조건에_따라_할인해준다() {
        // given
        List<OrderImpl> orders = new LinkedList<>();
        orders.add(new Order(MenuItem.CHOCOLATE_CAKE, 2, true));
        orders.add(new Order(MenuItem.RED_WINE, 5, true));

        int expectedDiscount = DiscountConstants.GIFT_DEFAULT_DISCOUNT;

        // when
        DiscountImpl discount = new GiftDiscount(orders);
        int resultDiscount = discount.discount();

        // then
        assertThat(resultDiscount).isEqualTo(expectedDiscount);
    }

    @Test
    void 총_주문금액이_120000원_이하이면_할인조건확인_함수가_false값을_가진다() {
        List<OrderImpl> orders = new LinkedList<>();
        orders.add(new Order(MenuItem.ZERO_COLA, 2, true));

        boolean expectedIsBenefit = false;

        // when
        DiscountImpl discount = new GiftDiscount(orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }

    @Test
    void 총_주문금액이_120000원_이상이면_할인조건확인_함수가_true값을_가진다() {
        List<OrderImpl> orders = new LinkedList<>();
        orders.add(new Order(MenuItem.CHOCOLATE_CAKE, 2, true));
        orders.add(new Order(MenuItem.RED_WINE, 5, true));

        boolean expectedIsBenefit = true;

        // when
        DiscountImpl discount = new GiftDiscount(orders);
        boolean resultIsBenefit = discount.isBenefit();

        // then
        assertThat(resultIsBenefit).isEqualTo(expectedIsBenefit);
    }


}