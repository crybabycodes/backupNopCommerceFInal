package nopcommerce.nopcommerceenums.excel;

public enum Excel {
    SHEET("Sheet1"),
    HEADER_NAME("Country"),
    PATH("C:\\Users\\MSI - Laptop\\Downloads\\Country (1).xlsx");

    private final String excel;

    private Excel(String excel) {
        this.excel = excel;
    }

    public String getExcel(){
        return excel;
    }
}
