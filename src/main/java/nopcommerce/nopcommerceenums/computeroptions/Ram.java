package nopcommerce.nopcommerceenums.computeroptions;

public enum Ram {
    RAM_OPTION_1("2 GB"),
    RAM_OPTION_2("4GB [+$20.00]"),
    RAM_OPTION_3("8GB [+$60.00]");

    private final String ram;

    private Ram(String ram) {
        this.ram = ram;
    }

    public String getRamOption() {
        return ram;
    }
}