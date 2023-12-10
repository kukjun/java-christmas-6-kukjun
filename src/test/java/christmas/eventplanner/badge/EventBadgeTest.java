package christmas.eventplanner.badge;


import org.junit.jupiter.api.Test;

import static christmas.eventplanner.badge.EventBadge.*;
import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {

    @Test
    void 혜택금액이_5000원_이하이면_없음을_name으로_가진다() {
        // given
        int benefitValue = 4500;

        // when
        Badge badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.show()).isEqualTo(NONE_BADGE);
    }

    @Test
    void 혜택금액이_5000원_이상_10000원_이하이면_별을_name으로_가진다() {
        // given
        int benefitValue = 9000;

        // when
        Badge badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.show()).isEqualTo(STAR_BADGE);
    }

    @Test
    void 혜택금액이_10000원_이상_20000원_이하이면_트리를_name으로_가진다() {
        // given
        int benefitValue = 18000;

        // when
        Badge badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.show()).isEqualTo(TREE_BADGE);
    }

    @Test
    void 혜택금액이_20000원_이상이면_산타를_name으로_가진다() {
        // given
        int benefitValue = 35000;

        // when
        Badge badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.show()).isEqualTo(SENTA_BADGE);
    }
}