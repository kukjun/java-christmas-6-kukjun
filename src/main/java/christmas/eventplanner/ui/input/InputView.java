package christmas.eventplanner.ui.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public interface InputView {
    int inputNumber();
    Map<String, Integer> inputOrderAndCount();
}
