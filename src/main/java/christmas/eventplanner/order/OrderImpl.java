package christmas.eventplanner.order;

public interface OrderImpl {

    int getOrderPrice();
    int getCount();

    String getMenuItemCategory();

    boolean isEligibleForDiscount();
}
