package christmas.eventplanner.order;

import christmas.eventplanner.util.constant.MenuItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void 오더의_주문한_음식과_갯수의_곱이_주문의_가격이어야_한다() {
        // given
        MenuItem expectedItem = MenuItem.CHOCOLATE_CAKE;
        int expectedQuantity = 2;

        // when
        Order order = new OrderImpl(expectedItem, expectedQuantity, true);

        // then
        assertThat(order.getOrderPrice()).isEqualTo(expectedItem.getPrice()*expectedQuantity);
    }

    @Test
    void 주문한_음식과_개수를_지정된_방식으로_표현해야_한다() {
        MenuItem expectedItem = MenuItem.CHOCOLATE_CAKE;
        int expectedQuantity = 2;

        // when
        Order order = new OrderImpl(expectedItem, expectedQuantity, true);

        // then
        assertThat(order.show()).isEqualTo(expectedItem.toString() + " " + expectedQuantity + "개");
    }

}