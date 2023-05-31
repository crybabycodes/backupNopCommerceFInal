package nopcommercetests;

import base.CommonAPI;
import nopcommerce.nopcommercepages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterLoginTest extends CommonAPI {

    @Test(priority = 1)
    public void validRegister() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.justRegister();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 2)
    public void verifyUserInfoIsDisplayed() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        MyAccountPage account = new MyAccountPage(getDriver());
        login.registerAndLogin();
        commerce.clickMyAccount();
        account.clickCustomerInfo();
        Assert.assertTrue(account.verifyNameIsDisplayed());
    }

    @Test(dataProvider = DataProviderCommerce.LoginData, dataProviderClass = DataProviderCommerce.class)
    public void registerLoginWithDataProvider(String password) {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerLoginWithDataProvider(password);
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 3)
    public void registerWithNoInput() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        commerce.clickOnRegisterButton();
        login.clickToRegister();
        Assert.assertTrue(login.nameIsRequiredText());
    }

    @Test(priority = 4)
    public void registerWithNoEmailAndPassword() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.registerNoEmailAndPassword();
        Assert.assertTrue(login.emailIsRequiredText());
        Assert.assertTrue(login.passwordIsRequiredText());
    }

    @Test(priority = 5)
    public void enterWeakPassword() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.registerWithWeakPassword();
        Assert.assertTrue(login.passwordMustHaveSixCharText());
    }

    @Test(priority = 6)
    public void registerWithWrongConfirmPassword() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.registerWithWrongConfirmPassword();
        Assert.assertTrue(login.confirmPasswordNotSameText());
    }

    @Test(priority = 7)
    public void registerAndLogin() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        NopCommerceHomePage commerce = new NopCommerceHomePage(getDriver());
        login.registerAndLogin();
        Assert.assertTrue(commerce.welcomeToOurStoreIsDisplayed());
    }

    @Test(priority = 8)
    public void forgotPasswordRecovery() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.forgotPasswordProcess();
        Assert.assertTrue(login.emailHasBeenSentText());
    }

    @Test(priority = 9)
    public void loginWithSQLInjectionEmail() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.justRegister();
        login.loginSQlInjectionEmail();
        Assert.assertTrue(login.emailErrorIsDisplayed());
    }

    @Test(priority = 10)
    public void loginWithSQLInjectionPassword() {
        RegisterLoginPage login = new RegisterLoginPage(getDriver());
        login.justRegister();
        login.loginSQlInjectionPassword();
        Assert.assertTrue(login.blockHeaderIsDisplayed());
    }
}
