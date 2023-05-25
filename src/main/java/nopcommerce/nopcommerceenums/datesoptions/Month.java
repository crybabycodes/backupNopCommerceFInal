package nopcommerce.nopcommerceenums.datesoptions;

public enum Month {
    January("January"),
    February("February"),
    March("March"),
    April("April"),
    May("May"),
    June("June"),
    July("July"),
    August("August"),
    September("September"),
    October("October"),
    November("November"),
    December("December");

    private final String stringValue;

    private Month(String month) {
        this.stringValue = month;
    }

    public String getMonth() {
        return stringValue;
    }
}
