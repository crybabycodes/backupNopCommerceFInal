package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceobjects.Customer;
import nopcommerce.nopcommercereusablemethods.Reusable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class MyAccountPage extends CommonAPI {

    @FindBy(xpath = "//a[normalize-space()='Customer info']")
    public WebElement customerInfo;

    @FindBy(css = "li[class='customer-addresses inactive'] a")
    public WebElement customerAddress;

    @FindBy(css = ".button-1.add-address-button")
    public WebElement addNewAddress;

    @FindBy(css = "#Address_LastName")
    public WebElement firstNameField;

    @FindBy(css = "#FirstName")
    public WebElement verifyFirstNameIsDisplayed;

    @FindBy(css = "#Address_FirstName")
    public WebElement lastNameField;

    @FindBy(css = "#Address_Email")
    public WebElement emailField;

    @FindBy(css = "#Address_CountryId")
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
    public WebElement closePasswordChangeTitle;

    @FindBy(xpath = "//a[normalize-space()='Log out']")
    public WebElement logOutButton;

    private static final Logger LOG = LoggerFactory.getLogger(MyAccountPage.class);

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkReviewItemHead() {
        LOG.info("Account review product is displayed");
        return checkDisplayed(accountReviewProductPage);
    }

    public boolean verifyAddressTextIsDisplayed() {
        LOG.info("New address added is displayed");
        return checkDisplayed(newAddressAddedText);
    }

    public boolean verifyAddressIsAdded() {
        LOG.info("New address info box is displayed");
        return checkDisplayed(newAddressInfoBox);
    }

    public boolean verifyNoAddresses() {
        LOG.info("Welcome to our store is displayed");
        return checkDisplayed(noAddressesText);
    }

    public boolean verifyPasswordChanged() {
        LOG.info("Password has changed is displayed");
        return  checkDisplayed(passwordHasChangedText);
    }

    public boolean verifyNameIsDisplayed() {
        LOG.info("Verify first name is displayed");
        return  checkDisplayed(verifyFirstNameIsDisplayed);
    }

    public void clickCustomerInfo() {
        click(customerInfo);
        LOG.info("Clicked on customer info");
    }

    public void clickCustomerAccountReviews() {
        click(customerAccountReviews);
        LOG.info("Clicked on customer account review");
    }

    public void logOutAndLogin() {
        click(closePasswordChangeTitle);
        LOG.info("Clicked on close password change title");
        waitFor(1);
        click(logOutButton);
        LOG.info("Clicked on logout button");
        new RegisterLoginPage(getDriver()).logBackIn();
        LOG.info("logged backed in");
    }

    public void changeOldPasswordToNewOne() {
        click(changePasswordLink);
        LOG.info("Clicked change password link");
        type(inputOldPasswordField, Reusable.password1);
        LOG.info("Typed old password");
        type(newPasswordField, Reusable.newPassword);
        LOG.info("Typed new password");
        type(confirmNewPasswordField, Reusable.newPassword);
        LOG.info("Typed new password in confirm password field");
        click(changePasswordButton);
        LOG.info("Clicked change password button");
    }

    public void deleteNewAddedAddress() {
        click(deleteAddress);
        LOG.info("Clicked delete address");
        okAlert();
        LOG.info("Clicked okay alert");
    }

    public void addCustomerAddress() {
        List<WebElement> click = Arrays.asList(customerAddress, addNewAddress);
        for (WebElement clickAll:click) {
         click(clickAll);
            LOG.info("Product review was successfully added");
        }
        new Reusable().firstNameLastNameEmail(new Customer(),firstNameField, lastNameField, emailField);
        LOG.info("Entered first last name and email");
        new Reusable().selectCountryAndState(countryField, stateField);
        LOG.info("Selected from country and state field");
        new Reusable().addressAndPhoneNumber(new Customer(), cityField, addressField, zipCodeField, phoneNumberField);
        LOG.info("Entered in city, address, zipcode and phone number field");
        click(saveAddressButton);
        LOG.info("Clicked save address button");
    }
}