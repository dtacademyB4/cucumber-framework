package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

public class SearchStepDefs {


    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {


        Driver.getDriver().get("http://automationpractice.com/index.php");

    }
    @When("The user enters a term Blouse to the search bar")
    public void the_user_enters_a_term_blouse_to_the_search_bar() {

        Driver.getDriver().findElement(By.id("search_query_top")).
                sendKeys("Blouse" + Keys.ENTER);

    }
    @Then("The search result should contain the term Blouse")
    public void the_search_result_should_contain_the_term_blouse() {

       String actual =  Driver.getDriver().findElement(By.xpath("(//a[@title='Blouse'])[2]")).getText();
        Assert.assertTrue(actual.equals("Blouse"));
    }
}
