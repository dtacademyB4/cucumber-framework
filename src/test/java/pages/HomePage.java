package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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






    public void clickOnProduct(String product){

        String xpath = "(//a[@title='"+product+"'])[2]" ;
        Driver.getDriver().findElement(By.xpath(xpath)).click();

    }



}
