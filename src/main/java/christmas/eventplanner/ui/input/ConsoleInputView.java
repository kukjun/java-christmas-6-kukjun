package christmas.eventplanner.ui.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    public int inputNumber() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

    public Map<String, Integer> inputOrderAndCount() {
        String input = Console.readLine();

        Map<String, Integer> orderAndCounts = Arrays.stream(input.split(","))
                .map(order -> order.split("-"))
                .filter(parts -> parts.length == 2)
                .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));

        return orderAndCounts;
    }

}
