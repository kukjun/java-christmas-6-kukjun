package christmas.eventplanner.ui.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.eventplanner.util.constant.MenuItem;
import christmas.eventplanner.util.constant.ui.input.InputConstants;
import christmas.eventplanner.util.constant.ui.input.InputError;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    public int inputDay() {
        int day = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                day = Integer.parseInt(input);

                validateDayRange(day);

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println(InputError.INVALID_SELECT_DAY.getErrorMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return day;

    }


    public Map<String, Integer> inputOrderAndCount() {
        Map<String, Integer> orders = new HashMap<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                orders = parseAndValidateOrder(input);
                validateTotalQuantity(orders);
                validateTotalCategoryOnlyDrink(orders);
                validInput = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        return orders;
    }

    // Validation 검사

    // 중복 Validation + 기타 Validation
    private Map<String, Integer> parseAndValidateOrder(String input) {
        Set<String> seenItems = new HashSet<>();

        return Arrays.stream(input.split(InputConstants.SPLIT_ORDER))
                .map(this::splitAndValidateOrder)
                .peek(parts -> {
                    if (!seenItems.add(parts[0])) {
                        throw new IllegalArgumentException(InputError.MENU_OVERLAP.getErrorMessage());
                    }
                })
                .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
    }

    // 문자열 형식 Validation
    private String[] splitAndValidateOrder(String order) {
        String[] parts = order.split(InputConstants.SPLIT_COUNT);
        if (parts.length != 2 || !isValidOrder(parts)) {
            throw new IllegalArgumentException(InputError.MENU_MISMATCHING.getErrorMessage());
        }

        return new String[]{parts[0].trim(), parts[1].trim()};
    }

    // 등록된 메뉴 이름, 갯수 Validation
    private boolean isValidOrder(String[] parts) {
        if (MenuItem.getMenuItemByName(parts[0].trim()) == null) {
            return false;
        }
        try {
            int quantity = Integer.parseInt(parts[1].trim());
            return quantity >= 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // 총 갯수 Validation
    private void validateTotalQuantity(Map<String, Integer> orders) {
        int totalQuantity = orders.values().stream().mapToInt(Integer::intValue).sum();
        if (totalQuantity > 20) {
            throw new IllegalArgumentException(InputError.EXCEED_ORDER_COUNTS.getErrorMessage());
        }
    }

    private void validateTotalCategoryOnlyDrink(Map<String, Integer> orders) {
        boolean allDrinks = orders.keySet().stream()
                .allMatch(item -> MenuItem.getMenuItemByName(item).getCategory().equals(InputConstants.DRINK));
        if (allDrinks) {
            throw new IllegalArgumentException(InputError.ORDER_ONLY_DRINK.getErrorMessage());
        }
    }

    private void validateDayRange(int day) {
        if (day < InputConstants.DAY_START || day > InputConstants.DAY_END) {
            throw new IllegalArgumentException(InputError.INVALID_SELECT_DAY.getErrorMessage());
        }

    }

}
