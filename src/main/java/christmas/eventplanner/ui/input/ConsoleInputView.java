package christmas.eventplanner.ui.input;

import camp.nextstep.edu.missionutils.Console;
import christmas.eventplanner.order.MenuItem;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {

    public static final int DAY_START = 1;
    public static final int DAY_END = 31;
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
                System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return day;

    }



    // TODO : 음료만 주문한 경우 Validation 추가
    public Map<String, Integer> inputOrderAndCount() {
        Map<String, Integer> orders = new HashMap<>();
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = Console.readLine();
                orders = parseAndValidateOrder(input);
                validateTotalQuantity(orders);
                validInput = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        return orders;
    }

    // Validation 검사

    // 중복 Validation
    private Map<String, Integer> parseAndValidateOrder(String input) {
        Set<String> seenItems = new HashSet<>();

        return Arrays.stream(input.split(","))
                .map(this::splitAndValidateOrder)
                .peek(parts -> {
                    if (!seenItems.add(parts[0])) {
                        throw new IllegalArgumentException("[ERROR] 중복된 메뉴 항목입니다. 다시 입력해 주세요.");
                    }
                })
                .collect(Collectors.toMap(parts -> parts[0], parts -> Integer.parseInt(parts[1])));
    }

    // 문자열 형식 Validation
    private String[] splitAndValidateOrder(String order) {
        String[] parts = order.split("-");
        if (parts.length != 2 || !isValidOrder(parts)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
            throw new IllegalArgumentException("[ERROR] 주문의 총 개수가 20개를 초과합니다. 다시 입력해 주세요.");
        }
    }

    private void validateDayRange(int day) {
        if (day < DAY_START || day > DAY_END) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

    }

}
