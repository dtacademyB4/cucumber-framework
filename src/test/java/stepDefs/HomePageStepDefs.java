package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomePageStepDefs {


    @Then("The following products should be displayed")
    public void the_following_products_should_be_displayed(List<String> expectedListOfProducts) {


        HomePage homePage = new HomePage();
        List<String> actualListOfProducts = BrowserUtilities.getElementsText(homePage.actualListOfWebelements);

        List<String> modifiableExpectedListOfProducts = new ArrayList<>(expectedListOfProducts);
        // We are creating a new ArrayList because Cucumber's List was not modifiable, in our case sortable


        Collections.sort(modifiableExpectedListOfProducts);
        Collections.sort(actualListOfProducts);


        Assert.assertEquals(modifiableExpectedListOfProducts, actualListOfProducts);




    }



    @Then("The page title should be {string}")
    public void the_page_title_should_be(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }



    @When("The user clicks on {string}")
    public void the_user_clicks_on(String link) {
          HomePage homePage = new HomePage();
          homePage.clickOnLink(link);
    }

    @Then("The title should be {string}")
    public void the_title_should_be(String title) {

       Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }





}
