package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.searchitems.Items;
import nopcommerce.nopcommerceobjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class NopCommerceHomePage extends CommonAPI {

    @FindBy(css = "a[class='ico-register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[@class='ico-account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Log in']")
    public WebElement loginButton;

    @FindBy(css = "a[class='ico-cart']")
    public WebElement shoppingCartButton;

    @FindBy(css = "img[alt='nopCommerce demo store']")
    public WebElement nopCommerceBackHomeButton;

    @FindBy(css = "#small-searchterms")
    public WebElement searchStoreField;

    @FindBy(css = "button[type='submit']")
    public WebElement searchStoreFieldButton;

    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    public WebElement addBuildYourComputerToCart;

    @FindBy(xpath = "//a[normalize-space()='Apple MacBook Pro 13-inch']")
    public WebElement clickAppleMacBookLink;

    @FindBy(css = "a[href='/apple-macbook-pro-13-inch']")
    public WebElement appleMacBookProToCartLink;

    @FindBy(css = "a[href='/htc-one-m8-android-l-50-lollipop']")
    public WebElement hTCM8AndroidPhoneToCartLink;

    @FindBy(css = "#add-to-cart-button-18")
    public WebElement addHTCPhoneToCart;

    @FindBy(xpath = "//button[contains(@onclick, 'AjaxCart.addproducttocomparelist')]")
    public WebElement compareHTCM8AndroidPhoneButton;

    @FindBy(css = "a[href='/25-virtual-gift-card']")
    public WebElement virtualGiftCardToCartLink;

    @FindBy(css = "button[onclick*='AjaxCart.addproducttocomparelist'][onclick*='/compareproducts/add/43']")
    public WebElement compareGiftCardButton;

    @FindBy(css = "p[class='content'] a")
    public WebElement productComparisonButton;

    @FindBy(css = ".clear-list")
    public WebElement clearList;

    @FindBy(css = "div[class='topic-block-title'] h2")
    public WebElement welcomeToOurStoreTitle;

    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    public WebElement addAppleToCart2;

    @FindBy(css = ".read-more")
    public WebElement clickReadMoreButton;

    @FindBy(css = "a[href='/contactus']")
    public WebElement clickContactUsLink;

    private static final Logger LOG = LoggerFactory.getLogger(NopCommerceHomePage.class);

    public NopCommerceHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean welcomeToOurStoreIsDisplayed() {
        LOG.info("Welcome to our store is displayed");
        return checkDisplayed(welcomeToOurStoreTitle);
    }

    public void clickOnRegisterButton() {
        click(registerButton);
        LOG.info("Clicked on register button");
    }

    public void clickOnLoginButton() {
        click(loginButton);
        LOG.info("Clicked on login button");
    }

    public void clickOnNopCommerceLogo() {
        click(nopCommerceBackHomeButton);
        LOG.info("Clicked on NopCommerce logo");
    }

    public void clickMyAccount() {
        click(myAccount);
        LOG.info("Clicked on my account");
    }

    public void clickContactUsLink() {
        click(clickContactUsLink);
        LOG.info("Clicked on contact us link");
    }

    public void addBuildYourComputerToCart() {
        click(addBuildYourComputerToCart);
        LOG.info("Clicked on build your computer to cart");
    }

    public void clickReadMoreButton() {
        click(clickReadMoreButton);
        LOG.info("Clicked on read more button");
    }

    public void clickAppleMacLinkAddReview() {
        click(clickAppleMacBookLink);
        LOG.info("Clicked on Apple Mac Book link");
        new ItemsPage(getDriver()).clickAppleLinkReview();
        LOG.info("Clicked on Apple link review");
        new ProductReviewsPage(getDriver()).submitProductReview(new Customer());
        LOG.info("Submit product review");
    }

    public void addHTCM8AndroidPhoneToCart() {
        click(hTCM8AndroidPhoneToCartLink);
        LOG.info("Clicked on HTCM8 Android phone to cart");
        click(addHTCPhoneToCart);
        LOG.info("Add HTCM8 Android phone to cart");
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        LOG.info("Clicked on shopping cart to checkout");
    }

    public void searchStoreItem(String search) {
        type(searchStoreField, search);
        LOG.info("Typed in search store field");
        click(searchStoreFieldButton);
        LOG.info("Clicked search store field button");
    }

    public void searchAppleAddToCart() {
        type(searchStoreField, Items.APPLE_MAC.getItems());
        LOG.info("Searched Apple Mac Book Pro");
        click(searchStoreFieldButton);
        LOG.info("Clicked on search store button");
        click(addAppleToCart2);
        LOG.info("Added Apple Mac Book Pro to cart");
        new ItemsPage(getDriver()).addAppleProductToCartToCheckOut();
        LOG.info("On Checkout");
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        LOG.info("Clicked on shopping cart to checkout");
    }

    public void addAppleMacBookProToCart() {
        click(appleMacBookProToCartLink);
        LOG.info("Clicked on Apple Mac Book Pro link");
        new ItemsPage(getDriver()).addAppleProductToCartToCheckOut();
        LOG.info("Added Apple Mac Book Pro to cart");
        click(nopCommerceBackHomeButton);
        LOG.info("Clicked on NopCommerce home button");
    }

    public void addVirtualGiftCardToCart() {
        click(virtualGiftCardToCartLink);
        LOG.info("Clicked on virtual gift card to cart");
        new ItemsPage(getDriver()).inputInfoForGiftCardAndAddToCart(new Customer());
        LOG.info("Inputted info for gift card and added to cart");
    }

    public void addMultipleItemsToCart() {
        click(hTCM8AndroidPhoneToCartLink);
        LOG.info("Clicked on HTCM8 Android phone link");
        click(addHTCPhoneToCart);
        LOG.info("Added HTCM8 Android to cart");
        clickOnNopCommerceLogo();
        LOG.info("Clicked on NopCommerce logo");
        addAppleMacBookProToCart();
        LOG.info("Added Apple Mac Book Pro to cart");
        addVirtualGiftCardToCart();
        LOG.info("Added virtual gift card to cart");
        click(nopCommerceBackHomeButton);
        LOG.info("Clicked on NopCommerce back home button");
        new ItemsPage(getDriver()).buildYourOwnComputerGoToShoppingCart();
        LOG.info("Added build your own computer to shopping cart");
    }

    public void compareItemsThenAddToCart() {
        click(compareHTCM8AndroidPhoneButton);
        LOG.info("Added HTCM8 Android phone to compare page");
        waitFor(1);
        click(compareGiftCardButton);
        LOG.info("Added virtual gift card to compare page");
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);
            LOG.info("Clicked compare list button, clear list, NopCommerce home button");
        }
        addHTCM8AndroidPhoneToCart();
        LOG.info("Added HTCM8 Android phone to cart");
    }

    public void compareItemsDeleteOneAddToCart() {
        click(compareHTCM8AndroidPhoneButton);
        LOG.info("Added HTCM8 Android phone to compare page");
        waitFor(1);
        click(compareGiftCardButton);
        LOG.info("Added virtual gift card to compare page");
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);
            LOG.info("Clicked compare list button, clear list, NopCommerce home button");
        }
        addVirtualGiftCardToCart();
        LOG.info("Added virtual gift card to cart");
        clickOnNopCommerceLogo();
        LOG.info("Clicked on NopCommerce logo");
        click(hTCM8AndroidPhoneToCartLink);
        LOG.info("Clicked HTCM8 Android phone to cart link");
        click(addHTCPhoneToCart);
        LOG.info("Added HTCM8 phone to cart");
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        LOG.info("Clicked shopping to cart to checkout");
        new CartPage(getDriver()).deleteHTCM8PhoneItem();
        LOG.info("Deleted HTCM8 Android item");
    }
}
