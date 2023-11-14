package christmas.eventplanner.badge;


import christmas.eventplanner.util.constant.badge.BadgeItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventBadgeTest {

    @Test
    void 혜택금액이_5000원_이하이면_없음을_name으로_가진다() {
        // given
        int benefitValue = 4500;
        String expectedName = BadgeItem.NONE_BADGE.getName();

        // when
        BadgeImpl badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.toString()).isEqualTo(expectedName);
    }

    @Test
    void 혜택금액이_5000원_이상_10000원_이하이면_별을_name으로_가진다() {
        // given
        int benefitValue = 9000;
        String expectedName = BadgeItem.STAR_BADGE.getName();

        // when
        BadgeImpl badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.toString()).isEqualTo(expectedName);
    }

    @Test
    void 혜택금액이_10000원_이상_20000원_이하이면_트리를_name으로_가진다() {
        // given
        int benefitValue = 18000;
        String expectedName = BadgeItem.TREE_BADGE.getName();

        // when
        BadgeImpl badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.toString()).isEqualTo(expectedName);
    }

    @Test
    void 혜택금액이_20000원_이상이면_산타를_name으로_가진다() {
        // given
        int benefitValue = 35000;
        String expectedName = BadgeItem.SENTA_BADGE.getName();

        // when
        BadgeImpl badge = new EventBadge(benefitValue);

        // then
        assertThat(badge.toString()).isEqualTo(expectedName);
    }
}