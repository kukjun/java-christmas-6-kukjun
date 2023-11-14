package christmas.eventplanner.util.constant.discount.calendar;

public enum WeekdayDiscountCalendar {
    DAY_3(3), DAY_4(4), DAY_5(5), DAY_6(6), DAY_7(7),
    DAY_10(10), DAY_11(11), DAY_12(12), DAY_13(13), DAY_14(14),
    DAY_17(17), DAY_18(18), DAY_19(19), DAY_20(20), DAY_21(21),
    DAY_24(24), DAY_25(25), DAY_26(26), DAY_27(27), DAY_28(28), DAY_31(31);

    private final int discountDay;

    WeekdayDiscountCalendar(int discountDays) {
        this.discountDay = discountDays;
    }

    public int getDiscountDay() {
        return discountDay;
    }

    public static boolean isDiscountDay(int day) {
        for(WeekdayDiscountCalendar weekdayDiscountCalendar : values()) {
            if(weekdayDiscountCalendar.getDiscountDay() == day){
                return true;
            }
        }
        return false;
    }
}
