package christmas.eventplanner.order;

public interface Order {

    int getOrderPrice();
    int getCount();

    String getMenuItemCategory();

    boolean isEligibleForDiscount();

    String show();
}
