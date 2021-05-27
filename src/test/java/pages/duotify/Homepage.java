package pages.duotify;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@onclick=\"openPage('settings.php')\"]")
    public WebElement userDetailsLink;

    @FindBy(xpath = "//button[.='USER DETAILS']")
    public WebElement userDetailsButton;

    @FindBy(name = "email")
    public WebElement emailInputBox;


    @FindBy(xpath = "//button[.='SAVE']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[.='Update successful']")
    public WebElement successMessage;








}
