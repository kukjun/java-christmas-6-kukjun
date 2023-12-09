package christmas.eventplanner.order;

public interface Order {

    int getOrderPrice();
    int getCount();

    String getMenuItemCategory();

    boolean isEqualsCategory(String categoryName);

    boolean isEligibleForDiscount();

    String show();
}
