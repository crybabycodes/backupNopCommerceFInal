package nopcommerce.nopcommercerandom;

import nopcommerce.nopcommerceenums.datesoptions.Day;
import nopcommerce.nopcommerceenums.datesoptions.Month;
import nopcommerce.nopcommerceenums.datesoptions.Year;

import java.util.Random;

public class Date {

    private static Random random = new Random();

    public static String randomDay() {
        Day[] days = Day.values();
        int randomIndex = random.nextInt(days.length);
        return String.valueOf(days[randomIndex].getDay());
    }

    public static String randomMonth() {
        Month[] months = Month.values();
        int randomIndex = random.nextInt(months.length);
        return months[randomIndex].getMonth();
    }

    public static String randomYear() {
        Year[] years = Year.values();
        int randomIndex = random.nextInt(years.length);
        return years[randomIndex].getYear();
    }
}
