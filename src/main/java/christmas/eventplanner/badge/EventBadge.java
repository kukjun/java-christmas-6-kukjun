package christmas.eventplanner.badge;

import christmas.eventplanner.util.constant.badge.BadgeItem;

public class EventBadge implements BadgeImpl{

    private final String name;

    public EventBadge(int sumBenefit) {
        if (sumBenefit < 5000) {
            this.name = BadgeItem.NONE_BADGE.getName();
            return;
        }
        if (sumBenefit < 10000) {
            this.name = BadgeItem.STAR_BADGE.getName();
            return;
        }
        if (sumBenefit < 20000) {
            this.name = BadgeItem.TREE_BADGE.getName();
            return;
        }
        this.name = BadgeItem.SENTA_BADGE.getName();
    }

    @Override
    public String toString() {
        return name;
    }
}
