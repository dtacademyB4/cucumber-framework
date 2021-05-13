package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {




    @FindBy(xpath= "(//a[@title='Blouse'])[2]")
    public WebElement searchResult;

    @FindBy(xpath= "//p[@class='alert alert-warning']")
    public WebElement errorMessage;

    public String getErrorMessageText(){
        return errorMessage.getText();
    }


    public String getSearchResultText(){
        return searchResult.getText();
    }

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
