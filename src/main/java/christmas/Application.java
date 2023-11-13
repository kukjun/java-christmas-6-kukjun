package christmas;

import christmas.eventplanner.DecemberEventPlanner;
import christmas.eventplanner.EventPlanner;
import christmas.eventplanner.ui.ConsoleEventPlannerUI;
import christmas.eventplanner.ui.EventPlannerUI;
import christmas.eventplanner.ui.input.ConsoleInputView;
import christmas.eventplanner.ui.input.InputView;
import christmas.eventplanner.ui.output.ConsoleOutputView;
import christmas.eventplanner.ui.output.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new ConsoleOutputView();
        InputView inputView = new ConsoleInputView();
        EventPlannerUI eventPlannerUI = new ConsoleEventPlannerUI(inputView, outputView);
        EventPlanner eventPlanner = new DecemberEventPlanner(eventPlannerUI);
        eventPlanner.run();
    }
}
