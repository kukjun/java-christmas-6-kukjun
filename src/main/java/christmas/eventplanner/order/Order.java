package christmas.eventplanner.order;

import christmas.eventplanner.order.menu.MenuItem;

public class Order implements OrderImpl {
    private final MenuItem menuItem;
    private final int count;
    private final boolean discountEligible;

    public Order(MenuItem menuItem, int count, boolean discountEligible) {
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
    public String toString() {
        return menuItem.toString() + " " + count + "개";
    }

}
