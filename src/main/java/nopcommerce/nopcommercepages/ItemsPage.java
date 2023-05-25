package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.datesoptions.Day;
import nopcommerce.nopcommerceobjects.Customer;
import nopcommerce.nopcommercerandom.Computer;
import nopcommerce.nopcommercerandom.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static nopcommerce.nopcommercerandom.Computer.random;

public class ItemsPage extends CommonAPI {

    @FindBy(xpath = "//select[@id='product_attribute_1']")
    public WebElement selectProcessorFromDropDown;

    @FindBy(xpath = "//select[@id='product_attribute_2']")
    public WebElement selectRAMFromDropDown;

    @FindBy(xpath = "//input[@id='product_attribute_3_6']")
    public WebElement HDD320GBRadioButton;

    @FindBy(css = "#product_attribute_3_7")
    public WebElement HDD400GBRadioButton;

    @FindBy(xpath = "//input[@id='product_attribute_4_8']")
    public WebElement OSVistaHome;

    @FindBy(xpath = "//input[@id='product_attribute_4_9']")
    public WebElement OSVistaPremium;

    @FindBy(xpath = "//input[@id='product_attribute_5_11']")
    public WebElement checkBoxAcrobatReader;

    @FindBy(xpath = "//input[@id='product_attribute_5_12']")
    public WebElement checkBoxTotalCommander;

    @FindBy(xpath = "//button[@id='add-to-cart-button-1']")
    public WebElement addBuildYourOwnComputerToCart;

    @FindBy(xpath = "//button[@id='add-to-cart-button-4']")
    public WebElement addAppleProductToCart;

    @FindBy(xpath = "//a[normalize-space()='Add your review']")
    public WebElement addAppleMacBookReview;

    @FindBy(css = "#giftcard_43_RecipientName")
    public WebElement inputRecipientsNameForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_RecipientEmail']")
    public WebElement inputRecipientsEmailForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_SenderName']")
    public WebElement inputSenderNameForGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_SenderEmail']")
    public WebElement inputSenderEmailForGiftCardField;

    @FindBy(xpath = "//textarea[@id='giftcard_43_Message']")
    public WebElement inputMessageForGiftCardField;

    @FindBy(xpath = "//button[@id='add-to-cart-button-43']")
    public WebElement addGiftCardToCart;

    @FindBy(css = "p[class='content'] a")
    public WebElement clickShoppingCartButton;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    public WebElement goToShoppingCartButton;

    @FindBy(css = "#product_enteredQuantity_1")
    public WebElement changeProductQuantity;

    @FindBy(css = "#add-to-cart-button-1")
    public WebElement updateCartButton;

    public ItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAppleLinkReview() {
        click(addAppleMacBookReview);
    }

    public void addAppleProductToCartToCheckOut() {
        click(addAppleProductToCart);
    }

    public void clickShoppingCartToCheckOut() {
        click(goToShoppingCartButton);
    }

    public void changeProductQuantity() {
        clear(changeProductQuantity);
        type(changeProductQuantity, Date.randomDay());
        waitFor(1);
        click(updateCartButton);
        waitFor(1);
        click(clickShoppingCartButton);
    }

    public void mistakeChangeProductQuantity() {
        clear(changeProductQuantity);
        type(changeProductQuantity, Date.randomDay());
        waitFor(1);
        click(updateCartButton);
        click(clickShoppingCartButton);
        new CartPage(getDriver()).updateCartEditComputer();
        clear(changeProductQuantity);
        type(changeProductQuantity, String.valueOf(Day._1.getDay()));
        click(updateCartButton);
        click(clickShoppingCartButton);
    }

    public void buildYourOwnComputerGoToShoppingCart() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        inputBuildYourOwnComputer();
        click(goToShoppingCartButton);
    }

    public void buildYourOwnComputerAddToCart() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        inputBuildYourOwnComputer();
    }

    public void addComputerAndGiftCardToCart() {
        buildYourOwnComputerAddToCart();
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        new NopCommerceHomePage(getDriver()).addVirtualGiftCardToCart();
        click(goToShoppingCartButton);
    }

    public void inputInfoForGiftCardAndAddToCart(Customer customer) {
        List<String> giftCard = Arrays.asList(customer.getFullName(), customer.getEmail(), customer.getSenderName());
        List<WebElement> giftCardElements = Arrays.asList(inputRecipientsNameForGiftCardField, inputRecipientsEmailForGiftCardField, inputSenderNameForGiftCardField );
        for (int i = 0; i < giftCard.size() ; i++) {
            type(giftCardElements.get(i), giftCard.get(i));
        }
        clearAndType(inputSenderEmailForGiftCardField, customer.getSenderEmail());
        type(inputMessageForGiftCardField, customer.getMessage());
        click(addGiftCardToCart);
    }

    public void inputBuildYourOwnComputer() {
        selectFromDropdown(selectProcessorFromDropDown, Computer.randomCPU());
        selectFromDropdown(selectRAMFromDropDown, Computer.randomRam());
        List<WebElement> hDD = Arrays.asList(HDD320GBRadioButton, HDD400GBRadioButton);
        WebElement selectedHDD = getRandomElement(hDD);
        click(selectedHDD);
        List<WebElement> oS = Arrays.asList(OSVistaHome, OSVistaPremium);
        WebElement selectOS = getRandomElement(oS);
        click(selectOS);
        List<WebElement> softwareOptions = Arrays.asList(checkBoxAcrobatReader, checkBoxTotalCommander);
        for (WebElement softwareOption : softwareOptions) {
            click(softwareOption);
        }
        click(addBuildYourOwnComputerToCart);
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }
}
