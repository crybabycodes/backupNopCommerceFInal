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
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        ProductReviewsPage product = new ProductReviewsPage(getDriver());
        login.registerAndLogin();
        commerce.clickAppleMacLinkAddReview();
        Assert.assertTrue(product.reviewWasAdded());
        commerce.clickMyAccount();
        account.clickCustomerAccountReviews();
        Assert.assertTrue(account.checkReviewItemHead());
    }

    @Test()
    public void testAddNewAddress() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
    }

    @Test()
    public void testAddNewAddressAndDelete() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.addCustomerAddress();
        Assert.assertTrue(account.verifyAddressTextIsDisplayed());
        Assert.assertTrue(account.verifyAddressIsAdded());
        account.deleteNewAddedAddress();
        Assert.assertTrue(account.verifyNoAddresses());
    }

    @Test()
    public void testChangeCustomerInfo() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.clickCustomerInfo();
        login.changeCustomerInfo();
        Assert.assertTrue(login.verifyCustomerInfoTextIsDisplayed());
    }

    @Test()
    public void testChangeOldPasswordWithNewOne() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
    }

    @Test()
    public void testChangePasswordLogoutLogBackIn() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.changeOldPasswordToNewOne();
        Assert.assertTrue(account.verifyPasswordChanged());
        account.logOutAndLogin();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }
}
