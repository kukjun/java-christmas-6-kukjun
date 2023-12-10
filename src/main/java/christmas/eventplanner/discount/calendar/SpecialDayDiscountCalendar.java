package christmas.eventplanner.discount.calendar;

public enum SpecialDayDiscountCalendar {

    DAY_3(3), DAY_10(10), DAY_17(17), DAY_24(24),
    DAY_25(25), DAY_31(31);

    private final int discountDay;

    SpecialDayDiscountCalendar(int discountDays) {
        this.discountDay = discountDays;
    }

    public int getDiscountDay() {
        return discountDay;
    }

    public static boolean isDiscountDay(int day) {
        for (SpecialDayDiscountCalendar specialDayDiscountCalendar : values()) {
            if (specialDayDiscountCalendar.getDiscountDay() == day) {
                return true;
            }
        }
        return false;
    }
}
