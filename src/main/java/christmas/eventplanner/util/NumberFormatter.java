package christmas.eventplanner.util;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatter {
    public static String formatNumber(int number) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.US);
        return formatter.format(number);
    }
}
