package nopcommercetests;

import base.CommonAPI;
import nopcommerce.nopcommerceenums.datesoptions.Day;
import nopcommerce.nopcommerceenums.datesoptions.Month;
import nopcommerce.nopcommerceenums.datesoptions.Year;
import nopcommerce.nopcommerceobjects.Customer;
import nopcommerce.nopcommercepages.MyAccountPage;
import nopcommerce.nopcommercepages.NopCommerceHomePage;
import nopcommerce.nopcommercepages.ProductReviewsPage;
import nopcommerce.nopcommercepages.RegisterLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerAccountTest extends CommonAPI {

    @Test()
    public void testReviewItem() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickAppleMacLinkAddReview();
        Assert.assertTrue(new ProductReviewsPage(getDriver()).reviewWasAdded());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).clickCustomerAccountReviews();
        Assert.assertTrue(new MyAccountPage(getDriver()).checkReviewItemHead());
    }

    @Test()
    public void testAddNewAddress() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).addCustomerAddress();
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyAddressTextIsDisplayed());
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyAddressIsAdded());
    }

    @Test()
    public void testAddNewAddressAndDelete() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).addCustomerAddress();
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyAddressTextIsDisplayed());
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyAddressIsAdded());
        new MyAccountPage(getDriver()).deleteNewAddedAddress();
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyNoAddresses());
    }

    @Test()
    public void testChangeCustomerInfo() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).clickCustomerInfo();
        new RegisterLoginPage(getDriver()).changeCustomerInfo(new Customer());
        Assert.assertTrue(new RegisterLoginPage(getDriver()).verifyCustomerInfoTextIsDisplayed());
    }

    @Test()
    public void testChangeOldPasswordWithNewOne() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).changeOldPasswordToNewOne(new Customer());
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyPasswordChanged());
    }

    @Test()
    public void testChangePasswordLogoutLogBackIn() {
        new RegisterLoginPage(getDriver()).registerAndLogin(new Customer());
        new NopCommerceHomePage(getDriver()).clickMyAccount();
        new MyAccountPage(getDriver()).changeOldPasswordToNewOne(new Customer());
        Assert.assertTrue(new MyAccountPage(getDriver()).verifyPasswordChanged());
        new MyAccountPage(getDriver()).logOutAndLogin();
        Assert.assertTrue(new NopCommerceHomePage(getDriver()).welcomeToOurStoreIsDisplayed());
    }
}