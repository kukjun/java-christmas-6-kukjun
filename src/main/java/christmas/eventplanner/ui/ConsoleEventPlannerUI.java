package christmas.eventplanner.ui;

import christmas.eventplanner.badge.BadgeImpl;
import christmas.eventplanner.discount.DiscountImpl;
import christmas.eventplanner.order.Order;
import christmas.eventplanner.ui.input.InputView;
import christmas.eventplanner.ui.output.OutputView;

import java.util.List;
import java.util.Map;

public class ConsoleEventPlannerUI implements EventPlannerUI {

    private final InputView inputView;
    private final OutputView outputView;

    public ConsoleEventPlannerUI(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void showEventPlanner() {
        outputView.showEventPlanner();
    }

    @Override
    public void requireRestaurantVisitDay() {
        outputView.requireRestaurantVisitDay();
    }

    @Override
    public int inputRestaurantVisitDay() {
        return inputView.inputDay();
    }

    @Override
    public void requireOrderAndCounts() {
        outputView.requireOrderAndCounts();
    }

    @Override
    public Map<String, Integer> inputOrderAndCounts() {
        return inputView.inputOrderAndCount();
    }

    @Override
    public void showPreviewEvent(int day) {
        outputView.showPreviewEvent(day);
    }

    @Override
    public void showOrderMenu(List<Order> orders) {
        outputView.showOrderMenu(orders);
    }

    @Override
    public void showOrderPriceBeforeDiscount(int orderPrice) {
        outputView.showOrderPriceBeforeDiscount(orderPrice);
    }

    @Override
    public void showGifts(Order order) {
        outputView.showGifts(order);
    }

    @Override
    public void showBenefits(List<DiscountImpl> discountList) {
        outputView.showBenefits(discountList);
    }

    @Override
    public void showSumBenefits(int sum) {
        outputView.showSumBenefits(sum);
    }

    @Override
    public void showPaymentAmountAfterDiscount(int payment) {
        outputView.showPaymentAmountAfterDiscount(payment);
    }

    @Override
    public void showEventBadge(BadgeImpl badge) {
        outputView.showEventBadge(badge);
    }
}
