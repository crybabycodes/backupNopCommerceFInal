package nopcommercetests;

import base.CommonAPI;
import nopcommerce.nopcommercepages.*;
import nopcommerce.nopcommerceenums.searchitems.Items;
import nopcommerce.nopcommerceobjects.Customer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends CommonAPI {

    @Test(enabled = false)
    public void testCreditCardCheckout() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new ItemsPage(getDriver()).buildYourOwnComputerGoToShoppingCart();
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).registeredUserCreditCardCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCheckMoneyCheckout() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new ItemsPage(getDriver()).buildYourOwnComputerGoToShoppingCart();
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).registeredUserCheckMoneyCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).thankYouTextIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testMultiItemsCheckOutCheckMoney() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).addMultipleItemsToCart();
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).registeredUserCheckMoneyCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testMultiItemsCheckOutCreditCard() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).addMultipleItemsToCart();
        new CartPage(getDriver()).clickCheckOut();
        new CheckOutPage(getDriver()).registeredUserCreditCardCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).thankYouTextIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testAddTwoItemsDeleteOneCheckOutCreditCard() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new ItemsPage(getDriver()).addComputerAndGiftCardToCart();
        new CartPage(getDriver()).removeAndAddItemWithCheckout();
        new CheckOutPage(getDriver()).registeredUserCreditCardCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).thankYouTextIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testAddTwoItemsDeleteOneCheckOutCheckMoney() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new ItemsPage(getDriver()).addComputerAndGiftCardToCart();
        new CartPage(getDriver()).removeAndAddItemWithCheckout();
        new CheckOutPage(getDriver()).registeredUserCheckMoneyCheckout(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCompareTwoItemsAddToCartCreditCard() {
        new NopCommerceHomePage(getDriver()).compareItemsThenAddToCart();
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCreditCard(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCompareTwoItemsAddToCartCheckMoney() {
        new NopCommerceHomePage(getDriver()).compareItemsThenAddToCart();
        new ItemsPage(getDriver()).clickShoppingCartToCheckOut();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCheckMoney(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCompareAddClearDeleteCheckoutGuestCreditCard() {
        new NopCommerceHomePage(getDriver()).compareItemsDeleteOneAddToCart();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCreditCard(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testCompareAddClearDeleteCheckoutGuestCheckMoney() {
        new NopCommerceHomePage(getDriver()).compareItemsDeleteOneAddToCart();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCheckMoney(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testSearchItemCheckOutGuestCreditCard() {
        new NopCommerceHomePage(getDriver()).searchAppleAddToCart();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCreditCard(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testSearchItemCheckOutGuestCheckMoney() {
        new NopCommerceHomePage(getDriver()).searchAppleAddToCart();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCheckMoney(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = true)
    public void testChangeQuantityOfItemCheckOutGuestCreditCard() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        new ItemsPage(getDriver()).buildYourOwnComputerAddToCart();
        new ItemsPage(getDriver()).changeProductQuantity();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCreditCard(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testChangeQuantityOfItemCheckOutGuestCheckMoney() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        new ItemsPage(getDriver()).buildYourOwnComputerAddToCart();
        new ItemsPage(getDriver()).changeProductQuantity();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCheckMoney(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testChangeQuantityUpdateOfItemCheckOutGuestCheckMoney() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        new ItemsPage(getDriver()).buildYourOwnComputerAddToCart();
        new ItemsPage(getDriver()).mistakeChangeProductQuantity();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCheckMoney(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }

    @Test(enabled = false)
    public void testChangeQuantityUpdateOfItemCheckOutGuestCreditCard() {
        new NopCommerceHomePage(getDriver()).addBuildYourComputerToCart();
        new ItemsPage(getDriver()).buildYourOwnComputerAddToCart();
        new ItemsPage(getDriver()).mistakeChangeProductQuantity();
        new CheckOutPage(getDriver()).checkOutAsGuestWithCreditCard(new Customer());
        Assert.assertTrue(new CheckOutCompletePage(getDriver()).yourOrderHasBeenProcessedIsDisplayed());
        new CheckOutCompletePage(getDriver()).clickBackToHomeButton();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }
}