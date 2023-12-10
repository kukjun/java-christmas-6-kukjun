package christmas.eventplanner.badge;


public class EventBadge implements Badge {

    public static final String NONE_BADGE = "없음";
    public static final String STAR_BADGE = "별";
    public static final String TREE_BADGE = "트리";
    public static final String SENTA_BADGE = "산타";

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
    public String show() {
        return name;
    }
}
