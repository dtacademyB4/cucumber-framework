package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductDetailsPage;
import utilities.BrowserUtilities;
import utilities.Driver;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

import static  org.junit.Assert.*;

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


    @Then("The product details should match the info in an excel file {string} and sheet {string}")
    public void the_product_details_should_match_the_info_in_an_excel_file_and_sheet(String file, String sheet) throws Throwable {

        boolean exceptionThrown = false;
        Throwable e = null;

        ExcelUtils excelUtils = new ExcelUtils(file, sheet);

        List<Map<String, String>> dataAsMap = excelUtils.getDataAsMap();

        System.out.println(dataAsMap);

        // Go through the list of maps
        for (int i = 0; i < dataAsMap.size(); i++) {

            Map<String, String> eachRow = dataAsMap.get(i);
            // If the Execute is equal to Y:
            if(eachRow.get("Execute").equalsIgnoreCase("Y")){
                // Getting the expected data from excel file
                String expectedProductName = eachRow.get("Products");
                String expectedPrice = eachRow.get("Price");
                String expectedModel= eachRow.get("Model");
                String expectedComposition = eachRow.get("Composition");
                String expectedStyle = eachRow.get("Styles");

                // Getting the actual data from UI
                HomePage homePage = new HomePage();
                homePage.clickOnProduct(expectedProductName);
                ProductDetailsPage pd = new ProductDetailsPage();
                String actualProductName = pd.productName.getText();
                String  actualPrice = pd.price.getText();
                String  actualModel= pd.model.getText();
                String  actualComposition =pd.composition.getText();
                String  actualStyle = pd.style.getText();

                // Assert the actual info from UI with the expected info from dataAsMap
                try {
                    assertEquals(expectedProductName, actualProductName);
                    assertEquals(expectedPrice, actualPrice);
                    assertEquals(expectedModel, actualModel);
                    assertEquals(expectedComposition, actualComposition);
                    assertEquals(expectedStyle, actualStyle);

                    excelUtils.setCellData("PASS", "Status", i + 1);
                }catch(Throwable ex){
                    e = ex;
                    exceptionThrown = true;
                    e.printStackTrace();
                    excelUtils.setCellData("FAIL", "Status", i + 1);

                }
                // Write PASS or FAIL back to the excel file


                Driver.getDriver().navigate().back();
            }else{
                excelUtils.setCellData("SKIP", "Status", i+1);
            }


        }





            // If the Execute is equal to N:
            // Write SKIP back to the excel file
       if(exceptionThrown){   // Manual creation of softAssert
           throw  e;
       }

    }


}
