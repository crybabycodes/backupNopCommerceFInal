package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.searchitems.Items;
import nopcommerce.nopcommerceobjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Arrays;
import java.util.Collections;
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

    @FindBy(css = "img[alt='nopCommerce demo store'][src='https://demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png']")
    public WebElement nopCommerceBackHomeButton;

    @FindBy(id = "small-searchterms")
    public WebElement searchStoreField;

    @FindBy(css = "button[type='submit']")
    public WebElement searchStoreFieldButton;

    @FindBy(xpath = "//div[@class='page-body']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addBuildYourComputerToCart;

    @FindBy(xpath = "//a[normalize-space()='Apple MacBook Pro 13-inch']")
    public WebElement clickAppleMacBookLink;

    @FindBy(xpath = "//div[@class='item-grid']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addAppleMacBookProToCartButton;

    @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/div[3]/div[1]/div[2]/div[3]/div[2]/button[1]")
    public WebElement addHTCM8AndroidPhoneToCart;

    @FindBy(xpath = "//div[@class='master-wrapper-content']//div[3]//div[1]//div[2]//div[3]//div[2]//button[2]")
    public WebElement compareHTCM8AndroidPhoneButton;

    @FindBy(xpath = "//div[@class='product-grid home-page-product-grid']//div[4]//div[1]//div[2]//div[3]//div[2]//button[1]")
    public WebElement addVirtualGiftCardToCart;

    @FindBy(xpath = "//div[@class='product-grid home-page-product-grid']//div[4]//div[1]//div[2]//div[3]//div[2]//button[2]")
    public WebElement compareGiftCardButton;

    @FindBy(css = "p[class='content'] a")
    public WebElement productComparisonButton;

    @FindBy(css = ".clear-list")
    public WebElement clearList;

    @FindBy(css = "div[class='topic-block-title'] h2")
    public WebElement welcomeToOurStoreTitle;

    @FindBy(css = ".button-2.product-box-add-to-cart-button")
    public WebElement addAppleToCart2;

    public NopCommerceHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnRegisterButton() {
        click(registerButton);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

    public void clickOnNopCommerceLogo() {
        click(nopCommerceBackHomeButton);
    }

    public void clickMyAccount() {
        click(myAccount);
    }

    public boolean welcomeToOurStoreIsDisplayed() {
        return checkDisplayed(welcomeToOurStoreTitle);
    }

    public void addBuildYourComputerToCart() {
        click(addBuildYourComputerToCart);
    }

    public void clickAppleMacLinkAddReview() {
        click(clickAppleMacBookLink);
        new ItemsPage(getDriver()).clickAppleLinkReview();
        new ProductReviewsPage(getDriver()).submitProductReview(new Customer());
    }

    public void addHTCM8AndroidPhoneToCart() {
        click(addHTCM8AndroidPhoneToCart);
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
    }

    public void searchStoreItem(String search) {
        type(searchStoreField, search);
        click(searchStoreFieldButton);
    }

    public void searchAppleAddToCart() {
        type(searchStoreField, Items.APPLE_MAC.getItems());
        click(searchStoreFieldButton);
        click(addAppleToCart2);
        new ItemsPage(getDriver()).addAppleProductToCartToCheckOut();
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
    }

    public void addAppleMacBookProToCart() {
        List<WebElement> apple = Collections.singletonList(addAppleMacBookProToCartButton);
        for (WebElement addAppleToCart : apple) {
            click(addAppleToCart);
        }
        new ItemsPage(getDriver()).addAppleProductToCartToCheckOut();
        click(nopCommerceBackHomeButton);
    }

    public void addVirtualGiftCardToCart() {
        List<WebElement> virtualCard = Arrays.asList(addVirtualGiftCardToCart, shoppingCartButton);
        for (WebElement addVirtualCardToCart : virtualCard) {
            click(addVirtualCardToCart);
        }
        new ItemsPage(getDriver()).inputInfoForGiftCardAndAddToCart(new Customer());
    }

    public void addMultipleItemsToCart() {
        click(addHTCM8AndroidPhoneToCart);
        waitFor(1);
        addAppleMacBookProToCart();
        addVirtualGiftCardToCart();
        click(nopCommerceBackHomeButton);
        addBuildYourComputerToCart();
        new ItemsPage(getDriver()).buildYourOwnComputerGoToShoppingCart();
    }

    public void compareItemsThenAddToCart() {
        click(compareHTCM8AndroidPhoneButton);
        waitFor(1);
        click(compareGiftCardButton);
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);

        }
        addVirtualGiftCardToCart();
        doubleClick(nopCommerceBackHomeButton, addHTCM8AndroidPhoneToCart);
    }

    public void compareItemsDeleteOneAddToCart() {
        click(compareHTCM8AndroidPhoneButton);
        waitFor(1);
        click(compareGiftCardButton);
        waitFor(1);
        List<WebElement> click = Arrays.asList(productComparisonButton, clearList, nopCommerceBackHomeButton);
        for (WebElement clickAll:click) {
            click(clickAll);

        }
        addVirtualGiftCardToCart();
        doubleClick(nopCommerceBackHomeButton, addHTCM8AndroidPhoneToCart);
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        new CartPage(getDriver()).deleteHTC8PhoneItem();
    }
}