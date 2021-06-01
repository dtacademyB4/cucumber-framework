package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;

public class HomePage {
    @FindBy(id = "search_query_top")
    public WebElement searchBar;

    @FindBy(xpath = "//ul[@id='homefeatured']//a[@class='product-name']")
    public List<WebElement> actualListOfWebelements;


    @FindBy(partialLinkText = "Sign in")
    public WebElement signInLink;
    
    
    
    
    
    
    







    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }





    public void clickOnLink(String link){

        String xpath = "(//a[.='"+link+"'])[1]" ;
        BrowserUtilities.jsClick(Driver.getDriver().findElement(By.xpath(xpath)));
    }




    public void clickOnProduct(String product){

        String xpath = "(//a[@title='"+product+"'])[2]" ;
        Driver.getDriver().findElement(By.xpath(xpath)).click();

    }


    @FindBy(partialLinkText = "Sign in")
    public WebElement signInfdggLink1fdb;

    @FindBy(partialLinkText = "Sign in")
    public WebElement signgfdgInLink2;



}
