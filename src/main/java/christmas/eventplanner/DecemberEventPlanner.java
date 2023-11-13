package christmas.eventplanner;

import christmas.eventplanner.order.Order;
import christmas.eventplanner.ui.EventPlannerUI;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DecemberEventPlanner implements EventPlanner{

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

        List<Order> orders = new LinkedList<>();
        // map -> order list 변환 필요
//        ui.showOrderMenu(orders);
        int orderPrice = 50000;
        ui.showOrderPriceBeforeDiscount(orderPrice);

        // 샴페인 order로 추가
//        ui.showGifts(order);

        // 할인 목록 추가
//        ui.showBenefits(discounts);

        int sum = 1000;
        ui.showSumBenefits(sum);

        int payment = 9000;
        ui.showPaymentAmountAfterDiscount(payment);

        // 뱃지 추가
//        ui.showEventBadge(badge);

    }
}
