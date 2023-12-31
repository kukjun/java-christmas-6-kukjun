package christmas.eventplanner;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.badge.EventBadge;
import christmas.eventplanner.discount.*;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.order.OrderImpl;
import christmas.eventplanner.ui.EventPlannerUI;
import christmas.eventplanner.util.constant.MenuItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DecemberEventPlanner implements EventPlanner {

    private final EventPlannerUI ui;
    private final List<DiscountImpl> benefitDiscounts = new LinkedList<>();

    public DecemberEventPlanner(EventPlannerUI ui) {
        this.ui = ui;
    }

    public void run() {

        int day = selectDays();
        List<OrderImpl> orders = selectOrders(day);
        findOrderSum(orders);

        // 증정
        findGiftBenefit(orders);

        // 할인
        findDiscountBenefit(orders, day);

        // 총 할인액
        int benefitSum = findBenefitSum();

        // 총 지불 금액
        findPayments(orders, benefitSum);

        // 뱃지 적용 상태
        findBadge(benefitSum);
    }

    private int selectDays() {
        ui.showEventPlanner();
        ui.requireRestaurantVisitDay();
        return ui.inputRestaurantVisitDay();
    }

    private List<OrderImpl> selectOrders(int day) {
        ui.requireOrderAndCounts();

        Map<String, Integer> rawOrders = ui.inputOrderAndCounts();
        ui.showPreviewEvent(day);

        List<OrderImpl> orders = rawOrders.entrySet().stream()
                .map(entry -> new Order(MenuItem.getMenuItemByName(entry.getKey()), entry.getValue(), true))
                .collect(Collectors.toList());

        ui.showOrderMenu(orders);

        return orders;
    }

    private void findOrderSum(List<OrderImpl> orders) {
        int orderPrice = 0;
        for (OrderImpl order : orders) {
            orderPrice += order.getOrderPrice();
        }
        ui.showOrderPriceBeforeDiscount(orderPrice);
    }

    private void findGiftBenefit(List<OrderImpl> orders) {
        GiftDiscount giftDiscount = new GiftDiscount(orders);
        if(giftDiscount.isBenefit()) {
            Order order = new Order(MenuItem.CHAMPAGNE, 1, false);
            orders.add(order);
            benefitDiscounts.add(giftDiscount);
            ui.showGifts(order);
        }
    }

    private void findDiscountBenefit(List<OrderImpl> orders, int day) {
        List<DiscountImpl> discounts = new LinkedList<>();

        discounts.add(new DDayDiscount(day, orders));
        discounts.add(new SpecialDiscount(day, orders));
        discounts.add(new WeekdayDiscount(day, orders));
        discounts.add(new WeekendDiscount(day, orders));

        for (DiscountImpl discount : discounts) {
            if (discount.isBenefit()) {
                benefitDiscounts.add(discount);
            }
        }

        // 할인 목록 조회
        ui.showBenefits(benefitDiscounts);
    }

    private int findBenefitSum() {
        int benefitSum = 0;
        for(DiscountImpl discount : benefitDiscounts) {
            benefitSum+= discount.discount();
        }
        ui.showSumBenefits(benefitSum);
        return benefitSum;
    }

    private void findPayments(List<OrderImpl> orders, int benefitSum) {
        int totalOrderPrice = 0;
        for (OrderImpl order : orders) {
            totalOrderPrice += order.getOrderPrice();
        }

        int payment = totalOrderPrice - benefitSum;

        ui.showPaymentAmountAfterDiscount(payment);
    }

    private void findBadge(int benefitSum) {
        BadgeImpl badge = new EventBadge(benefitSum);
        ui.showEventBadge(badge);
    }

}
