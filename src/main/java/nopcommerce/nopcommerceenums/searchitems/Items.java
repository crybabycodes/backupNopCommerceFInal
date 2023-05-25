package nopcommerce.nopcommerceenums.searchitems;

public enum Items {
    BUILD_COMPUTER("Build your own computer"),
    APPLE_MAC("Apple MacBook Pro 13-inch"),
    HTC_ANDROID("HTC One M8 Android L 5.0 Lollipop"),
    VIRTUAL_CARD("$25 Virtual Gift Card");

    private final String items;

    private Items (String items) {
        this.items = items;
    }

    public String getItems() {
        return items;
    }
}
