package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.country.Country;
import nopcommerce.nopcommerceenums.excel.Excel;
import nopcommerce.nopcommerceobjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExcelReader;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyAccountPage extends CommonAPI {

    @FindBy(xpath = "//a[normalize-space()='Customer info']")
    public WebElement customerInfo;

    @FindBy(css = "li[class='customer-addresses inactive'] a")
    public WebElement customerAddress;

    @FindBy(css = ".button-1.add-address-button")
    public WebElement addNewAddress;

    @FindBy(id = "Address_LastName")
    public WebElement firstNameField;

    @FindBy(css = "#Address_FirstName")
    public WebElement lastNameField;

    @FindBy(css = "#Address_Email")
    public WebElement emailField;

    @FindBy(css = "##Address_CountryId")
    public WebElement countryField;

    @FindBy(css = "#Address_StateProvinceId")
    public WebElement stateField;

    @FindBy(css = "#Address_City")
    public WebElement cityField;

    @FindBy(css = "#Address_Address1")
    public WebElement addressField;

    @FindBy(css = "#Address_ZipPostalCode")
    public WebElement zipCodeField;

    @FindBy(css = "#Address_PhoneNumber")
    public WebElement phoneNumberField;

    @FindBy(css = "button[class='button-1 save-address-button']")
    public WebElement saveAddressButton;

    @FindBy(css = ".content")
    public WebElement newAddressAddedText;

    @FindBy(css = ".info")
    public WebElement newAddressInfoBox;

    @FindBy(css = ".button-2.delete-address-button")
    public WebElement deleteAddress;

    @FindBy(css = ".no-data")
    public WebElement noAddressesText;

    @FindBy(css = ".button-1.add-address-button")
    public WebElement addAnotherAddress;

    @FindBy(xpath = "//a[normalize-space()='Change password']")
    public WebElement changePasswordLink;

    @FindBy(css = "#OldPassword")
    public WebElement inputOldPasswordField;

    @FindBy(css = "#NewPassword")
    public WebElement newPasswordField;

    @FindBy(css = "#ConfirmNewPassword")
    public WebElement confirmNewPasswordField;

    @FindBy(css = "button[class='button-1 change-password-button']")
    public WebElement changePasswordButton;

    @FindBy(css = ".content")
    public WebElement passwordHasChangedText;

    @FindBy(css = "a[href='/customer/productreviews']")
    public WebElement customerAccountReviews;

    @FindBy(css = ".page.account-page.my-product-reviews-list-page")
    public WebElement accountReviewProductPage;

    @FindBy(css = "span[title='Close']")
    public WebElement closePasswordChangeTittle;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    public WebElement logOutButton;

    public static String newPassword;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkReviewItemHead() {
        return checkDisplayed(accountReviewProductPage);
    }

    public boolean verifyAddressTextIsDisplayed() {
        return checkDisplayed(newAddressAddedText);
    }

    public boolean verifyAddressIsAdded() {
        return checkDisplayed(newAddressInfoBox);
    }

    public boolean verifyNoAddresses() {
        return checkDisplayed(noAddressesText);
    }

    public boolean verifyPasswordChanged() {
        return  checkDisplayed(passwordHasChangedText);
    }

    public void clickCustomerInfo() {
        click(customerInfo);
    }

    public void clickCustomerAccountReviews() {
        click(customerAccountReviews);
    }

    public void logOutAndLogin() {
        click(closePasswordChangeTittle);
        waitFor(1);
        click(logOutButton);
        new RegisterLoginPage(getDriver()).logBackIn();
    }

    public void changeOldPasswordToNewOne(Customer customer) {
        click(changePasswordLink);
        String oldPassword = RegisterLoginPage.password;
        type(inputOldPasswordField,oldPassword);
        type(newPasswordField, customer.getNewPassword());
        type(confirmNewPasswordField, customer.getNewPassword());
        click(changePasswordButton);
    }

    public void deleteNewAddedAddress() {
        click(deleteAddress);
        okAlert();
    }

    public void addCustomerAddress() {
        List<WebElement> click = Arrays.asList(customerAddress, addNewAddress);
        for (WebElement clickAll:click) {
         click(clickAll);
        }
        firstNameLastNameEmail(new Customer());
        addressAndPhoneNumber(new Customer());
        click(saveAddressButton);
    }

    public void firstNameLastNameEmail(Customer customer) {
        List<String> nameFields = Arrays.asList(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        List<WebElement> nameElements = Arrays.asList(firstNameField, lastNameField, emailField);
        for (int i = 0; i < nameFields.size(); i++) {
            type(nameElements.get(i), nameFields.get(i));
        }
    }

    public void addressAndPhoneNumber(Customer customer) {
        selectCountryAndState(new Customer());
        List<String> billingFields = Arrays.asList(customer.getCity(), customer.getAddress(), customer.getZipCode(), customer.getPhoneNumber());
        List<WebElement> billingFieldsElements = Arrays.asList(cityField, addressField, zipCodeField, phoneNumberField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void selectCountryAndState(Customer customer) {
        List<String> countryList = new ExcelReader(Excel.PATH.getExcel()).getEntireColumnForGivenHeader(Excel.SHEET.getExcel(), Excel.HEADER_NAME.getExcel());
        String randomCountry = countryList.get(new Random().nextInt(countryList.size()));
        selectFromDropdown(countryField, randomCountry);
        if (Country.UNITED_STATES.getCountry().equals(randomCountry) || Country.CANADA.getCountry().equals(randomCountry)) {
            selectFromDropdown(stateField, customer.getState());
        }
    }
}