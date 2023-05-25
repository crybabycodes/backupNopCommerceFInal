package nopcommerce.nopcommerceenums.creditcard;

public enum ExpYear {
    _2023("2023"),
    _2024("2024"),
    _2025("2025"),
    _2026("2026"),
    _2027("2027"),
    _2028("2028"),
    _2029("2029"),
    _2030("2030"),
    _2031("2031"),
    _2032("2032"),
    _2033("2033"),
    _2034("2034"),
    _2035("2035"),
    _2036("2036"),
    _2037("2037");

    private final String year;

    private ExpYear(String year) {
        this.year = year;
    }

    public String getCardExpYear() {
        return year;
    }
}
