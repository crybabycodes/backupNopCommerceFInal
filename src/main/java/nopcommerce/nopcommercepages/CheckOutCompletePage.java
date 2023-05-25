package nopcommerce.nopcommercepages;

import base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends CommonAPI {

    @FindBy(xpath = "//h1[normalize-space()='Thank you']")
    public WebElement thankYouText;

    @FindBy(xpath = "//strong[normalize-space()='Your order has been successfully processed!']")
    public WebElement yourOrderHasBeenSuccessFullyProcessedText;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement backHomeButton;

    public CheckOutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickBackToHomeButton() {
        click(backHomeButton);
    }

    public boolean thankYouTextIsDisplayed() {
        return checkDisplayed(thankYouText);
    }

    public boolean yourOrderHasBeenProcessedIsDisplayed() {
        return checkDisplayed(yourOrderHasBeenSuccessFullyProcessedText);
    }
}