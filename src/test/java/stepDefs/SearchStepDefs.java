package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.SearchPage;
import runners.CukeRunner;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SearchStepDefs {




    @Given("The user is on the homepage")
    public void the_user_is_on_the_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }



    @When("The user enters a term {string} to the search bar")
    public void the_user_enters_a_term_to_the_search_bar(String product) {
        HomePage homePage = new HomePage();
        homePage.searchBar.sendKeys(product + Keys.ENTER);
    }


    @Then("The search result should contain the term Blouse")
    public void the_search_result_should_contain_the_term_blouse() {
       String actual = new SearchPage().getSearchResultText();
        Assert.assertTrue(actual.equals("Blouse"));
    }



    @Then("The error message should be displayed.")
    public void the_error_message_should_be_displayed() {

        SearchPage search = new SearchPage();
        String actual = search.getErrorMessageText();

        String expected = "No results were found for your search";
        Assert.assertTrue(actual.contains(expected));
    }


    @Then("The search result should contain the term Faded Short Sleeve T-shirts")
    public void the_search_result_should_contain_the_term_printed_dress() {

        String actual = new SearchPage().searchResult2.getText();
        Assert.assertTrue(actual.equals("Faded Short Sleeve T-shirtz"));

    }







}
