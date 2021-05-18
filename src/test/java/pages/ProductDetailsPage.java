package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class ProductDetailsPage {

    @FindBy(id = "our_price_display")
    public WebElement price;

    @FindBy(id = "quantity_wanted")
    public WebElement defaultQuantity;

    @FindBy(tagName = "h1")
    public WebElement productName;

    @FindBy(xpath = "//p[@id='product_condition']//span[@class='editable']")
    public WebElement condition;

    @FindBy(xpath = "//tr[@class='odd']//td[2]")
    public WebElement composition;

    @FindBy(xpath = "//tr[@class='even']//td[2]")
    public WebElement style;

    @FindBy(id = "group_1")
    public WebElement size;


    public String getFirstSelectedOption(){
        Select s = new Select(size);
      return  s.getFirstSelectedOption().getText();
    }


    public ProductDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
