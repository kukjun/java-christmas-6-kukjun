package christmas.eventplanner.util.constant.discount.calendar;

public enum WeekendDiscountCalendar {

    DAY_1(1), DAY_2(2), DAY_8(8), DAY_9(9), DAY_15(15),
    DAY_16(16), DAY_22(22), DAY_23(23), DAY_29(29), DAY_30(30);

    private final int discountDay;

    WeekendDiscountCalendar(int discountDays) {
        this.discountDay = discountDays;
    }

    public int getDiscountDay() {
        return discountDay;
    }

    public static boolean isDiscountDay(int day) {
        for (WeekendDiscountCalendar weekendDiscountCalendar : values()) {
            if (weekendDiscountCalendar.getDiscountDay() == day) {
                return true;
            }
        }
        return false;
    }
}
