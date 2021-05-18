package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class ProductDetailsStepDefs {


    @When("The user clicks on a product {string}")
    public void the_user_clicks_on_a_product(String product) {
            new HomePage().clickOnProduct(product);
    }

    @Then("The user should be taken to product details page with title {string}")
    public void the_user_should_be_taken_to_product_details_page_with_title(String title) {
        BrowserUtilities.waitForTitleContains(title, 5);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(title));
    }

    @Then("The price of the product should be {double}")
    public void the_price_of_the_product_should_be(Double price) {
          ProductDetailsPage pd = new ProductDetailsPage();
          String actual = pd.price.getText().replace("$", "");

          Assert.assertEquals(price, Double.valueOf(actual));
    }

    @Then("The default quantity should be {int}")
    public void the_default_quantity_should_be(Integer quantity) {
        ProductDetailsPage pd = new ProductDetailsPage();
       String actual = pd.defaultQuantity.getAttribute("value"); // make it fail
       Assert.assertEquals(quantity, Integer.valueOf(actual));
    }


    @Then("The product details should be the following")
    public void the_product_details_should_be_the_following(List<List<String>> dataTable) {

           ProductDetailsPage productDetailsPage = new ProductDetailsPage();

        List<String> products = dataTable.get(1);

        Assert.assertEquals(products.get(0), productDetailsPage.productName.getText());
        Assert.assertEquals(products.get(1), productDetailsPage.condition.getText());
        Assert.assertEquals(products.get(2), productDetailsPage.composition.getText());
        Assert.assertEquals(products.get(3), productDetailsPage.style.getText());
        Assert.assertEquals(products.get(4), productDetailsPage.price.getText().replace("$", ""));
        Assert.assertEquals(products.get(5), productDetailsPage.getFirstSelectedOption());



    }



    @Then("The product details should be the following using")
    public void the_product_details_should_be_the_following_using(List<Map<String,String>> dataTable) {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        Map<String, String> firstRow = dataTable.get(0);



        Assert.assertEquals(firstRow.get("Name"), productDetailsPage.productName.getText());
        Assert.assertEquals(firstRow.get("Price"), productDetailsPage.price.getText().replace("$", ""));
        Assert.assertEquals(firstRow.get("Style"), productDetailsPage.style.getText());
        Assert.assertEquals(firstRow.get("Composition"), productDetailsPage.composition.getText());
        Assert.assertEquals(firstRow.get("Size"), productDetailsPage.getFirstSelectedOption());
        Assert.assertEquals(firstRow.get("Condition"), productDetailsPage.condition.getText());


    }


}
