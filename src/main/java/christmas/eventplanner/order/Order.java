package christmas.eventplanner.order;

public class Order implements OrderImpl {
    private final MenuItem menuItem;
    private final int count;
    private final boolean discountEligible;

    public Order(MenuItem menuItem, int count, boolean discountEligible) {
        this.menuItem = menuItem;
        this.count = count;
        this.discountEligible = discountEligible;
    }

    public int getOrderPrice() {
        return menuItem.getPrice() * count;
    }

    public String getMenuItemCategory() {
        return menuItem.getCategory();
    }

    public boolean isEligibleForDiscount() {
        return discountEligible;
    }

    @Override
    public String toString() {
        return menuItem.toString() + " " + count + "개";
    }

}
