package lumababy.lumapages;

import base.CommonAPI;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatingBitch extends CommonAPI {

    @FindBy(css = "#firstname")
    public WebElement createFirstName;

    @FindBy(css = "#lastname")
    public WebElement createLastName;

    @FindBy(css = "#email_address")
    public WebElement createEmail;

    @FindBy(css = "#password")
    public WebElement createPassword;

    @FindBy(css = "#password-confirmation")
    public WebElement createPasswordConfirmation;

    @FindBy(css = "button[title='Create an Account'] span")
    public WebElement confirmAccountCreation;

    public AccountCreatingBitch(WebDriver driver) {PageFactory.initElements(driver, this);}

    public void createAccount() {
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().bothify("??????##@gmail.com");
        String passWord = new Faker().bothify("????????#####$%");
        type(createFirstName, firstName);
        type(createLastName, lastName);
        type(createEmail, email);
        type(createPassword, passWord);
        type(createPasswordConfirmation, passWord);
        click(confirmAccountCreation);
    }
}
