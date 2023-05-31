package nopcommercetests;

import base.CommonAPI;
import nopcommerce.nopcommercepages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends CommonAPI {

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testCreditCardCheckout(String creditNumber, String creditCode) {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        item.buildYourOwnComputerGoToShoppingCart();
        cart.clickCheckOut();
        checkout.registeredUserCreditCardCheckout(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 2)
    public void testCheckMoneyCheckout() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        item.buildYourOwnComputerGoToShoppingCart();
        cart.clickCheckOut();
        checkout.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 3)
    public void testMultiItemsCheckOutCheckMoney() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        commerce.addMultipleItemsToCart();
        cart.clickCheckOut();
        checkout.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testMultiItemsCheckOutCreditCard(String creditNumber, String creditCode) {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        commerce.addMultipleItemsToCart();
        cart.clickCheckOut();
        checkout.registeredUserCreditCardCheckout(creditNumber, creditCode);
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testAddTwoItemsDeleteOneCheckOutCreditCard(String creditNumber, String creditCode) {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        item.addComputerAndGiftCardToCart();
        cart.removeAndAddItemWithCheckout();
        checkout.registeredUserCreditCardCheckout(creditNumber, creditCode);
        Assert.assertTrue(complete.thankYouTextIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 6)
    public void testAddTwoItemsDeleteOneCheckOutCheckMoney() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        ItemsPage item = new ItemsPage(getDriver());
        CartPage cart = new CartPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        item.addComputerAndGiftCardToCart();
        cart.removeAndAddItemWithCheckout();
        checkout.registeredUserCheckMoneyCheckout();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testCompareTwoItemsAddToCartCreditCard(String creditNumber, String creditCode) {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.compareItemsThenAddToCart();
        checkout.checkOutAsGuestWithCreditCard(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 8)
    public void testCompareTwoItemsAddToCartCheckMoney() {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.compareItemsThenAddToCart();
        checkout.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testCompareAddClearDeleteCheckoutGuestCreditCard(String creditNumber, String creditCode) {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkout.checkOutAsGuestWithCreditCard(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 10)
    public void testCompareAddClearDeleteCheckoutGuestCheckMoney() {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.compareItemsDeleteOneAddToCart();
        checkout.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testSearchItemCheckOutGuestCreditCard(String creditNumber, String creditCode) {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.searchAppleAddToCart();
        checkout.checkOutAsGuestWithCreditCard(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 12)
    public void testSearchItemCheckOutGuestCheckMoney() {
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.searchAppleAddToCart();
        checkout.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testChangeQuantityOfItemCheckOutGuestCreditCard(String creditNumber, String creditCode) {
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart();
        item.changeProductQuantity();
        checkout.checkOutAsGuestWithCreditCard(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 14)
    public void testChangeQuantityOfItemCheckOutGuestCheckMoney() {
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart();
        item.changeProductQuantity();
        checkout.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 15)
    public void testChangeQuantityUpdateOfItemCheckOutGuestCheckMoney() {
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart();
        item.mistakeChangeProductQuantity();
        checkout.checkOutAsGuestWithCheckMoney();
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.CreditData , dataProviderClass = DataProviderCommerce.class)
    public void testChangeQuantityUpdateOfItemCheckOutGuestCreditCard(String creditNumber, String creditCode) {
        ItemsPage item = new ItemsPage(getDriver());
        CheckOutPage checkout= new CheckOutPage(getDriver());
        CheckOutCompletePage complete = new CheckOutCompletePage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.addBuildYourComputerToCart();
        item.buildYourOwnComputerAddToCart();
        item.mistakeChangeProductQuantity();
        checkout.checkOutAsGuestWithCreditCard(creditNumber, creditCode);
        Assert.assertTrue(complete.yourOrderHasBeenProcessedIsDisplayed());
        complete.clickBackToHomeButton();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}