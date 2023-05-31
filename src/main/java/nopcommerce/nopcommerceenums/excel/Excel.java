package nopcommerce.nopcommerceenums.excel;

public enum Excel {
    SHEET("Sheet1"),
    COUNTRY_HEADER("Country"),
    COUNTRY_PATH("C:\\Users\\MSI - Laptop\\Downloads\\Country (2).xlsx"),
    CC_PATH("C:\\Users\\MSI - Laptop\\Downloads\\DataProvider (2).xlsx");

    private final String excel;

    private Excel(String excel) {
        this.excel = excel;
    }

    public String getExcel(){
        return excel;
    }
}
