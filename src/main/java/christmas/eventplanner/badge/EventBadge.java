package christmas.eventplanner.badge;

public class EventBadge implements BadgeImpl{

    private final static String NONE_BADGE = "없음";
    private final static String STAR_BADGE = "별";
    private final static String TREE_BADGE = "트리";
    private final static String SENTA_BADGE = "산타";


    private final String name;

    public EventBadge(int sumBenefit) {
        if (sumBenefit < 5000) {
            this.name = NONE_BADGE;
            return;
        }
        if (sumBenefit < 10000) {
            this.name = STAR_BADGE;
            return;
        }
        if (sumBenefit < 20000) {
            this.name = TREE_BADGE;
            return;
        }
        this.name = SENTA_BADGE;
    }

    @Override
    public String toString() {
        return name;
    }
}
