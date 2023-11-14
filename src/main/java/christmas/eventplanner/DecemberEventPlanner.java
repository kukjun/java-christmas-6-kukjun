package christmas.eventplanner;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.badge.EventBadge;
import christmas.eventplanner.discount.*;
import christmas.eventplanner.order.menu.MenuItem;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.ui.EventPlannerUI;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecemberEventPlanner implements EventPlanner {

    private final EventPlannerUI ui;

    public DecemberEventPlanner(EventPlannerUI ui) {
        this.ui = ui;
    }

    public void run() {
        ui.showEventPlanner();
        ui.requireRestaurantVisitDay();
        int day = ui.inputRestaurantVisitDay();
        System.out.println("day = " + day);
        ui.requireOrderAndCounts();
        Map<String, Integer> rawOrders = ui.inputOrderAndCounts();
        System.out.println("rawOrders = " + rawOrders);
        ui.showPreviewEvent(day);

        List<OrderImpl> orders = rawOrders.entrySet().stream()
                .map(entry -> new Order(MenuItem.getMenuItemByName(entry.getKey()), entry.getValue(), true))
                .collect(Collectors.toList());

        ui.showOrderMenu(orders);

        int orderPrice = 0;
        for (OrderImpl order : orders) {
            orderPrice += order.getOrderPrice();
        }

        ui.showOrderPriceBeforeDiscount(orderPrice);

        List<DiscountImpl> discounts = new LinkedList<>();
        List<DiscountImpl> benefitDiscounts = new LinkedList<>();

        // 증정
        GiftDiscount giftDiscount = new GiftDiscount(orders);
        if(giftDiscount.isBenefit()) {
            Order order = new Order(MenuItem.CHAMPAGNE, 1, false);
            orders.add(order);
            benefitDiscounts.add(giftDiscount);
            ui.showGifts(order);
        }

        discounts.add(new DDayDiscount(day, orders));
        discounts.add(new SpecialDiscount(day, orders));
        discounts.add(new WeekdayDiscount(day, orders));
        discounts.add(new WeekendDiscount(day, orders));

        for (DiscountImpl discount : discounts) {
            if (discount.isBenefit()) {
                benefitDiscounts.add(discount);
            }
        }

        // 할인 목록 추가
        ui.showBenefits(benefitDiscounts);

        int benefitSum = 0;
        for(DiscountImpl discount : benefitDiscounts) {
            benefitSum+= discount.discount();
        }
        ui.showSumBenefits(benefitSum);

        int totalOrderPrice = 0;
        for (OrderImpl order : orders) {
            totalOrderPrice += order.getOrderPrice();
        }

        int payment = totalOrderPrice - benefitSum;

        ui.showPaymentAmountAfterDiscount(payment);

        BadgeImpl badge = new EventBadge(benefitSum);
        ui.showEventBadge(badge);

    }
}
