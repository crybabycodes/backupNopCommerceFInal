package nopcommerce.nopcommerceenums.computeroptions;

public enum CPU {
    CPU_1("2.2 GHz Intel Pentium Dual-Core E2200"),
    CPU_2("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

    private final String processor;

    private CPU(String processor) {
        this.processor = processor;
    }

    public String getProcessorOption() {
        return processor;
    }
}