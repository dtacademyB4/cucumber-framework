package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

public class CreateAccountPage {

    public CreateAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "address1")
    public WebElement address;


    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "postcode")
    public WebElement zipcode;

    @FindBy(id = "phone_mobile")
    public WebElement phone;

    @FindBy(id = "submitAccount")
    public WebElement registerButton;















    public void chooseDob(){
        new Select(Driver.getDriver().findElement(By.id("days"))).selectByValue( (1+ (int)(Math.random()*31)) + "");
        new Select(Driver.getDriver().findElement(By.id("months"))).selectByValue( (1+ (int)(Math.random()*12)) + "");
        new Select(Driver.getDriver().findElement(By.id("years"))).selectByValue( (1900+ (int)(Math.random()*122)) + "");
    }


    public void chooseState(){
        new Select(Driver.getDriver().findElement(By.id("id_state"))).selectByValue( (1+ (int)(Math.random()*53)) + "");

    }

    public void chooseState(String state){
        new Select(Driver.getDriver().findElement(By.id("id_state"))).selectByVisibleText(state);

    }


}
