package nopcommerce.nopcommercepages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class CartPage extends CommonAPI {

    @FindBy(css = "#termsofservice")
    public WebElement termsOfServiceRadioButton;

    @FindBy(css = "#checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//button[normalize-space()='Continue shopping']")
    public WebElement continueShoppingButton;

    @FindBy(css = "button[name='updatecart'][type='button']")
    public WebElement deleteItem;

    @FindBy(css = "#updatecart")
    public WebElement updateCartButton;

    @FindBy(xpath = "//a[normalize-space()='Edit']")
    public WebElement editComputer;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void updateCartEditComputer() {
        click(editComputer);
    }

    public void clickContinueShoppingButton() {
        click(continueShoppingButton);
    }

    public void clickCheckOut() {
        List<WebElement> checkOut = Arrays.asList(termsOfServiceRadioButton, checkoutButton);
        for (WebElement checkOutAll: checkOut) {
            click(checkOutAll);
        }
    }

    public void deleteSingleItem() {
        click(deleteItem);
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        waitFor(1);
    }

    public void removeAndAddHTC8Phone() {
        click(deleteItem);
        new NopCommerceHomePage(getDriver()).clickOnNopCommerceLogo();
        waitFor(1);
        new NopCommerceHomePage(getDriver()).addHTCM8AndroidPhoneToCart();
    }

    public void removeAndAddItemWithCheckout() {
        removeAndAddHTC8Phone();
        new CartPage(getDriver()).clickCheckOut();
    }

    public void deleteHTC8PhoneItem() {
        click(deleteItem);
        click(updateCartButton);
    }
}