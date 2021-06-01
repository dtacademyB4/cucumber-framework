package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email_create")
    public WebElement emailInputBox;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton2;






}
