package christmas.eventplanner;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.Application;
import christmas.eventplanner.util.constant.ui.input.InputError;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class DecemberEventPlannerTest extends NsTest {

    @Test
    void 날짜_입력범위_초과시_예외발생() {
        assertSimpleTest(() -> {
            runException("99");
            assertThat(output().contains(InputError.INVALID_SELECT_DAY.getErrorMessage()));
        });
    }

    @Test
    void 날짜_입력_포멧_불일치_시_예외발생() {
        assertSimpleTest(() -> {
            runException("김치");
            assertThat(output().contains(InputError.INVALID_SELECT_DAY.getErrorMessage()));
        });
    }

    @Test
    void 주문_입력_포멧_불일치_시_예외발생() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output().contains(InputError.MENU_MISMATCHING.getErrorMessage()));
        });
    }

    @Test
    void 주문_가능한_음식이_아닐시_예외발생() {
        assertSimpleTest(() -> {
            runException("3", "팹시-3");
            assertThat(output().contains(InputError.NOT_FOUND_MENU.getErrorMessage()));
        });
    }

    @Test
    void 주문_가능_수량_초과시_예외발생() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-30");
            assertThat(output().contains(InputError.MENU_OVERLAP.getErrorMessage()));
        });
    }

    @Test
    void 주문의_개수가_1보다_작을시_예외발생() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-0");
            assertThat(output().contains(InputError.COUNT_BIGGER_THEN_ONE.getErrorMessage()));
        });
    }

    @Test
    void 주문_후_예상_결졔_금액과_계산_금액_일치() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output().contains(
                    "135,754원"
            ));
        });
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}