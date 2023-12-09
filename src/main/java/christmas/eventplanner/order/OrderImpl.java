package christmas.eventplanner.order;

import christmas.eventplanner.util.constant.MenuItem;

public class OrderImpl implements Order {
    private final MenuItem menuItem;
    private final int count;
    private final boolean discountEligible;

    public OrderImpl(MenuItem menuItem, int count, boolean discountEligible) {
        this.menuItem = menuItem;
        this.count = count;
        this.discountEligible = discountEligible;
    }

    @Override
    public int getOrderPrice() {
        return menuItem.getPrice() * count;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getMenuItemCategory() {
        return menuItem.getCategory();
    }

    @Override
    public boolean isEligibleForDiscount() {
        return discountEligible;
    }

    @Override
    public String show() {
        return menuItem.toString() + " " + count + "개";
    }

}
