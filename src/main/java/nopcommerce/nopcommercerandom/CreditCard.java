package nopcommerce.nopcommercerandom;

import nopcommerce.nopcommerceenums.creditcard.CCProvider;
import nopcommerce.nopcommerceenums.creditcard.ExpMonth;
import nopcommerce.nopcommerceenums.creditcard.ExpYear;

import java.util.Random;

public class CreditCard {

    private static Random random = new Random();

    public static String randomCard() {
        CCProvider[] ccProviders = CCProvider.values();
        int randomIndex = random.nextInt(ccProviders.length);
        return ccProviders[randomIndex].getCardProvider();
    }

    public static String randomExpMonth() {
        ExpMonth[] expMonths = ExpMonth.values();
        int randomIndex = random.nextInt(expMonths.length);
        return expMonths[randomIndex].getCardExpMonth();
    }

    public static String randomExpYear() {
        ExpYear[] expYears = ExpYear.values();
        int randomIndex = random.nextInt(expYears.length);
        return expYears[randomIndex].getCardExpYear();
    }
}
