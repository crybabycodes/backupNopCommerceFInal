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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    public WebElement inputNameGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_RecipientEmail']")
    public WebElement inputEmailGiftCardField;

    @FindBy(xpath = "//input[@id='giftcard_43_SenderName']")
    public WebElement inputSendNameGiftCardField;

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

    @FindBy(css = ".bar-notification.error")
    public WebElement pleaseSelectRamAndHddDisplayed;

    private final Logger LOG = LoggerFactory.getLogger(ItemsPage.class);

    public ItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAppleLinkReview() {
        click(addAppleMacBookReview);
        LOG.info("Clicked on Apple link for review");
    }

    public void addAppleProductToCartToCheckOut() {
        click(addAppleProductToCart);
        LOG.info("Added Apple product to cart for checkout");
    }

    public void clickShoppingCartToCheckOut() {
        click(goToShoppingCartButton);
        LOG.info("Clicked on shopping cart for checkout");
    }

    public boolean noInputForComputerIsDisplayed() {
        LOG.info("Please select ram and hdd is displayed");
        return checkDisplayed(pleaseSelectRamAndHddDisplayed);
    }

    public void changeProductQuantity() {
        clear(changeProductQuantity);
        LOG.info("Cleared product quantity field");
        type(changeProductQuantity, (Date.randomDay()));
        LOG.info("Changed product quantity");
        click(updateCartButton);
        LOG.info("Clicked on update cart button");
        click(clickShoppingCartButton);
        LOG.info("Clicked on shopping cart button");
    }

    public void mistakeChangeProductQuantity() {
        clear(changeProductQuantity);
        LOG.info("Cleared product quantity field");
        type(changeProductQuantity, (Date.randomDay()));
        LOG.info("Changed product quantity");
        click(updateCartButton);
        LOG.info("Clicked on update cart button");
        click(clickShoppingCartButton);
        LOG.info("Clicked on shopping cart button");
        new CartPage(getDriver()).updateCartEditComputer();
        LOG.info("Updated cart and edited computer");
        clear(changeProductQuantity);
        LOG.info("Cleared product quantity field");
        type(changeProductQuantity, String.valueOf(Day._1.getDay()));
        LOG.info("Changed product quantity");
        click(updateCartButton);
        LOG.info("Clicked on update cart button");
        click(clickShoppingCartButton);
        LOG.info("Clicked on shopping cart button");
    }

    public void buildYourOwnComputerGoToShoppingCart() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        LOG.info("Added build-your-own computer to cart");
        inputBuildYourOwnComputer();
        LOG.info("Entered input for build-your-own computer");
        click(goToShoppingCartButton);
        LOG.info("Clicked on shopping cart for checkout");
    }

    public void buildYourOwnComputerAddToCart() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        LOG.info("Added build-your-own computer to cart");
        inputBuildYourOwnComputer();
        LOG.info("Entered input for build-your-own computer");
    }

    public void buildYourOwnComputerWithOutInputToCart() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        LOG.info("Added build-your-own computer to cart");
        click(addBuildYourOwnComputerToCart);
        LOG.info("Clicked on add-to-cart button");
    }

    public void addComputerAndGiftCardToCart() {
        buildYourOwnComputerAddToCart();
        LOG.info("Added build-your-own computer to cart");
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        LOG.info("Clicked on NopCommerce logo");
        new NopCommerceHomePage(getDriver()).addVirtualGiftCardToCart();
        LOG.info("Added virtual gift card to cart");
        click(goToShoppingCartButton);
        LOG.info("Clicked on shopping cart for checkout");
    }

    public void inputInfoForGiftCardAndAddToCart(Customer customer) {
        List<String> giftCard = Arrays.asList(customer.getFullName(), customer.getEmail(), customer.getSenderName());
        List<WebElement> giftCardElements = Arrays.asList(inputNameGiftCardField, inputEmailGiftCardField, inputSendNameGiftCardField);
        for (int i = 0; i < giftCard.size() ; i++) {
            type(giftCardElements.get(i), giftCard.get(i));
            LOG.info("Entered gift card information: {}", giftCard.get(i));
        }
        clearAndType(inputSenderEmailForGiftCardField, customer.getSenderEmail());
        LOG.info("Entered sender email for gift card");
        type(inputMessageForGiftCardField, customer.getMessage());
        LOG.info("Entered message for gift card");
        click(addGiftCardToCart);
        LOG.info("Added gift card to cart");
    }

    public void inputBuildYourOwnComputer() {
        selectFromDropdown(selectProcessorFromDropDown, Computer.randomCPU());
        LOG.info("Selected processor from dropdown");
        selectFromDropdown(selectRAMFromDropDown, Computer.randomRam());
        LOG.info("Selected RAM from dropdown");
        List<WebElement> hDD = Arrays.asList(HDD320GBRadioButton, HDD400GBRadioButton);
        WebElement selectedHDD = getRandomElement(hDD);
        click(selectedHDD);
        LOG.info("Selected HDD from available options");
        List<WebElement> oS = Arrays.asList(OSVistaHome, OSVistaPremium);
        WebElement selectOS = getRandomElement(oS);
        click(selectOS);
        LOG.info("Selected OS from available options");
        List<WebElement> softwareOptions = Arrays.asList(checkBoxAcrobatReader, checkBoxTotalCommander);
        for (WebElement softwareOption : softwareOptions) {
            click(softwareOption);
        }
        click(addBuildYourOwnComputerToCart);
        LOG.info("Added build-your-own computer to cart");
    }

    private WebElement getRandomElement(List<WebElement> elements) {
        int randomIndex = random.nextInt(elements.size());
        return elements.get(randomIndex);
    }
}
