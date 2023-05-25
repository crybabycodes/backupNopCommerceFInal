package nopcommerce.nopcommercepages;

import base.CommonAPI;
import nopcommerce.nopcommerceobjects.Customer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductReviewsPage extends CommonAPI {

    @FindBy(css = "#AddProductReview_Title")
    public WebElement reviewTitleInput;

    @FindBy(css = "#AddProductReview_ReviewText")
    public WebElement reviewTextInput;

    @FindBy(css = "button[name='add-review']")
    public WebElement submitReviewButton;

    @FindBy(css = "div[class='result']")
    public WebElement productReviewSuccessfullyAdded;

    public ProductReviewsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean reviewWasAdded() {
        return checkDisplayed(productReviewSuccessfullyAdded);
    }

    public void submitProductReview(Customer customer) {
        List<String> review = Collections.singletonList(customer.getMessage());
        List<WebElement> reviewWebElements = Arrays.asList(reviewTitleInput, reviewTextInput);
        for (int i = 0; i < review.size() ; i++) {
            type(reviewWebElements.get(i), review.get(i));
        }
        click(submitReviewButton);
    }
}