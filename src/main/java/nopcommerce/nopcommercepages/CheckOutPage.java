package nopcommerce.nopcommercepages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import nopcommerce.nopcommerceenums.country.Country;
import nopcommerce.nopcommerceenums.creditcard.CC;
import nopcommerce.nopcommerceenums.excel.Excel;
import nopcommerce.nopcommercerandom.CreditCard;
import nopcommerce.nopcommerceobjects.Customer;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.ConnectDB;
import utility.ExcelReader;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CheckOutPage extends CommonAPI {

    @FindBy(css = "#BillingNewAddress_FirstName")
    public WebElement billingFirstNameField;

    @FindBy(css = "#BillingNewAddress_LastName")
    public WebElement billingLastNameField;

    @FindBy(css = "#BillingNewAddress_Email")
    public WebElement billingEmailField;

    @FindBy(css = "#BillingNewAddress_CountryId")
    public WebElement selectCountryDropDown;

    @FindBy(css = "#BillingNewAddress_StateProvinceId")
    public WebElement selectStateDropDown;

    @FindBy(css = "#BillingNewAddress_City")
    public WebElement billingCityField;

    @FindBy(css = "#BillingNewAddress_Address1")
    public WebElement billingAddressField;

    @FindBy(css = "#BillingNewAddress_ZipPostalCode")
    public WebElement billingZipCodeField;

    @FindBy(css = "#BillingNewAddress_PhoneNumber")
    public WebElement billingPhoneNumberField;

    @FindBy(css = "button[onclick='Billing.save()']")
    public WebElement continueToShippingButton;

    @FindBy(xpath = "//button[@class='button-1 shipping-method-next-step-button']")
    public WebElement continueToPaymentButton;

    @FindBy(xpath = "//input[@id='paymentmethod_0']")
    public WebElement checkMoneyOrderRadioButton;

    @FindBy(css = "#paymentmethod_1")
    public WebElement creditCardRadioButton;

    @FindBy(css = "button[class='button-1 payment-method-next-step-button']")
    public WebElement continueToPaymentInfoButton;

    @FindBy(css = "#CreditCardType")
    public WebElement selectCreditCard;

    @FindBy(css = "#CardholderName")
    public WebElement cardHolderNameField;

    @FindBy(css = "#CardNumber")
    public WebElement cardNumberField;

    @FindBy(css = "#ExpireMonth")
    public WebElement selectMonthExpirationDate;

    @FindBy(css = "#ExpireYear")
    public WebElement selectYearExpirationDate;

    @FindBy(css = "#CardCode")
    public WebElement cardCodeField;

    @FindBy(css = ".button-1.payment-info-next-step-button")
    public WebElement continueToConfirmOrderButton;

    @FindBy(css = ".button-1.confirm-order-next-step-button")
    public WebElement confirmCheckOutCompleteButton;

    @FindBy(xpath = "//li[text()='Wrong card number']")
    public WebElement wrongCardNumberText;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//p[@class='back-link']//a[@href='#']")
    public WebElement returnBackToCreditCard;

    @FindBy(css = "li[class='payment-method'] span[class='value']")
    public WebElement creditCardIsDisplayed;

    public CheckOutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean creditCardPaymentIsDisplayed() {
        return checkDisplayed(creditCardIsDisplayed);
    }

    private boolean wrongCardNumberIsDisplayed() {
            return checkDisplayed(wrongCardNumberText);
    }

    public void checkOutAsGuestWithCheckMoney(Customer customer) {
        CartPage cart = new CartPage(getDriver());
        RegisterLoginPage guest = new RegisterLoginPage(getDriver());
        cart.clickCheckOut();
        guest.checkOutAsGuest();
        firstNameLastNameEmailEntered(customer);
        addressAndPhoneNumberEntered(customer);
        continueWithCheckMoneyOrder();
    }

    public void checkOutAsGuestWithCreditCard(Customer customer) {
        new CartPage(getDriver()).clickCheckOut();
        new RegisterLoginPage(getDriver()).checkOutAsGuest();
        firstNameLastNameEmailEntered(customer);
        addressAndPhoneNumberEntered(customer);
        continueWithCreditCard(customer);
    }

    public void registeredUserCheckMoneyCheckout(Customer customer) {
        addressAndPhoneNumberEntered(customer);
        continueWithCheckMoneyOrder();
    }

    public void registeredUserCreditCardCheckout(Customer customer) {
        copyText(billingFirstNameField);
        copyText(billingLastNameField);
        selectCountryAndState();
        addressAndPhoneNumberEntered(customer);
        continueWithCreditCard(customer);
    }

    public void continueWithCheckMoneyOrder() {
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, checkMoneyOrderRadioButton, continueToPaymentInfoButton, continueToConfirmOrderButton, confirmCheckOutCompleteButton);
        for (WebElement clickAll : click) {
            click(clickAll);
        }
    }

    public void continueWithCreditCard(Customer customer) {
        List<WebElement> click = Arrays.asList(continueToShippingButton, continueToPaymentButton, creditCardRadioButton, continueToPaymentInfoButton);
        for (WebElement clickAll:click) {
            click(clickAll);
        }
        selectFromDropdown(selectCreditCard, CreditCard.randomCard());
        List<String> cardHolder = List.of(customer.getFirstName() + " " + customer.getLastName(), new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_NUMBER.getCcCredentials()).toString());
        List<WebElement> cardHolderElements = Arrays.asList(cardHolderNameField, cardNumberField);
        for (int i = 0; i < cardHolder.size(); i++) {
            type(cardHolderElements.get(i), cardHolder.get(i).replace("[", "").replace("]", ""));
        }
        selectFromDropdown(selectMonthExpirationDate, CreditCard.randomExpMonth());
        selectFromDropdown(selectYearExpirationDate, CreditCard.randomExpYear());
        type(cardCodeField, new ConnectDB().readMysqlDataBaseColumn(CC.CC_TABLE.getCcCredentials(), CC.CC_CODE.getCcCredentials()).toString().replace("[", ""));
        click(continueToConfirmOrderButton);
        Assert.assertTrue(creditCardPaymentIsDisplayed());
        click(confirmCheckOutCompleteButton);
    }

    public void firstNameLastNameEmailEntered(Customer customer) {
        List<String> billingFields = Arrays.asList(customer.getFirstName(), customer.getLastName(), customer.getEmail());
        List<WebElement> billingFieldsElements = Arrays.asList(billingFirstNameField, billingLastNameField, billingEmailField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void addressAndPhoneNumberEntered(Customer customer) {
        selectCountryAndState();
        List<String> billingFields = Arrays.asList(customer.getCity(), customer.getAddress(), customer.getZipCode(), customer.getPhoneNumber());
        List<WebElement> billingFieldsElements = Arrays.asList(billingCityField, billingAddressField, billingZipCodeField, billingPhoneNumberField);
        for (int i = 0; i < billingFields.size(); i++) {
            type(billingFieldsElements.get(i), billingFields.get(i));
        }
    }

    public void selectCountryAndState() {
        List<String> countryList = new ExcelReader(Excel.PATH.getExcel()).getEntireColumnForGivenHeader(Excel.SHEET.getExcel(), Excel.HEADER_NAME.getExcel());
        String randomCountry = countryList.get(new Random().nextInt(countryList.size()));
        String state = new Faker().address().state();
        selectFromDropdown(selectCountryDropDown, randomCountry);
        if (Country.UNITED_STATES.getCountry().equals(randomCountry) || Country.CANADA.getCountry().equals(randomCountry)) {
            selectFromDropdown(selectStateDropDown, state);
        }
    }
}