package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyAccountPage {


    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@title='View my customer account']//span")
    public WebElement fullName;

    @FindBy(partialLinkText = "Sign out")
    public WebElement signOutLink;
    @FindBy(partialLinkText = "Sign out")
    public WebElement signOutLink1;





}
