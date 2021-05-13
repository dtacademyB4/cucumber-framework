package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



}
