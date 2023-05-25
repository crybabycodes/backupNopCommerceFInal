package nopcommerce.nopcommerceenums.creditcard;

public enum CCProvider {
    CARD_VISA("Visa"),
    CARD_MASTER_CARD("Master card"),
    CARD_DISCOVER("Discover"),
    CARD_AMEX("Amex");

    private final String card;

    private CCProvider(String card) {
        this.card = card;
    }

    public String getCardProvider() {
        return card;
    }
}