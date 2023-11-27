package christmas.eventplanner.util.constant.badge;

public enum BadgeItem {

    NONE_BADGE("없음"),
    STAR_BADGE("별"),
    TREE_BADGE("트리"),
    SENTA_BADGE("산타");
    private final String name;

    BadgeItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
