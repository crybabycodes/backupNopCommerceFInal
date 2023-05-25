package nopcommerce.nopcommerceenums.creditcard;

public enum CC {
    CC_TABLE("cc_table"),
    CC_NUMBER("cc_number"),
    CC_CODE("cc_code");

    private final String ccCredentials;

    private CC(String ccNumber) {
        this.ccCredentials = ccNumber;
    }

    public String getCcCredentials(){
        return ccCredentials;
    }
}
