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

public class AboutNopCommerce extends CommonAPI {

    @FindBy(css = "#AddNewComment_CommentTitle")
    public WebElement inputTitle;

    @FindBy(css = "#AddNewComment_CommentText")
    public WebElement inputComment;

    @FindBy(css = "button[name='add-comment']")
    public WebElement addNewComment;

    @FindBy(css = ".result")
    public WebElement newCommentIsAddedSuccessfully;

    public AboutNopCommerce(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyCommentIsAdded() {
        return checkDisplayed(newCommentIsAddedSuccessfully);
    }

    public void leaveAComment(Customer customer) {
        new NopCommerceHomePage(getDriver()).clickReadMoreButton();
        List<String> input = Arrays.asList(customer.getMessage(), customer.getMessage());
        List<WebElement> webElementsInput = Arrays.asList(inputTitle, inputComment);
        for (int i = 0; i <input.size() ; i++) {
            type(webElementsInput.get(i), input.get(i) );
        }
        click(addNewComment);
    }
}
