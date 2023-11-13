package christmas.eventplanner.order;

public class Order implements OrderImpl {
    private final MenuItem menuItem;
    private final int count;

    public Order(MenuItem menuItem, int count) {
        this.menuItem = menuItem;
        this.count = count;
    }

    @Override
    public String toString() {
        return menuItem.toString() + " " + count + "개";
    }

}
