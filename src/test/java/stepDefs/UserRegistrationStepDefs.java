package stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class UserRegistrationStepDefs {

    String first;
    String last;






    @When("The user navigates to Login page")
    public void the_user_navigates_to_login_page() {
          new HomePage().signInLink.click();
    }

    @When("The user enters a valid email address and click on create account button")
    public void the_user_enters_a_valid_email_address_and_click_on_create_account_button() {
         LoginPage loginPage = new LoginPage();
         loginPage.emailInputBox.sendKeys(new Faker().internet().emailAddress());
         loginPage.createAccountButton.click();
    }

    @When("The user passes the valid info and clicks on register")
    public void the_user_passes_the_valid_info_and_clicks_on_register() {
        Faker fakeData = new Faker();
        CreateAccountPage createAccountPage = new CreateAccountPage();
        first = fakeData.name().firstName();
        createAccountPage.firstName.sendKeys(first);
        last = fakeData.name().lastName();
        createAccountPage.lastName.sendKeys(last);
        createAccountPage.password.sendKeys(fakeData.internet().password());
        createAccountPage.chooseDob();
        createAccountPage.address.sendKeys(fakeData.address().streetAddress());
        createAccountPage.city.sendKeys(fakeData.address().city());
        createAccountPage.chooseState();
        createAccountPage.zipcode.sendKeys("22150");
        createAccountPage.phone.sendKeys(fakeData.phoneNumber().cellPhone());
        createAccountPage.registerButton.click();







    }

    @Then("The user should land on My Account page")
    public void the_user_should_land_on_my_account_page() {

        Assert.assertTrue( Driver.getDriver().getTitle().contains("My account"));
    }

    @Then("The name should be correct")
    public void the_user_should_see_message() {

        MyAccountPage myAccountPage = new MyAccountPage();
        String actualName = myAccountPage.fullName.getText();
        String expectedName = first +" "+ last;

        Assert.assertEquals(expectedName, actualName);
    }


    @When("The user passes the following info and clicks on register")
    public void the_user_passes_the_following_info_and_clicks_on_register(List<Map<String,String>> dataTable) throws InterruptedException {

        CreateAccountPage createAccountPage = new CreateAccountPage();

        Map<String, String> userInfo = dataTable.get(0);
        first =userInfo.get("first_name");
        createAccountPage.firstName.sendKeys(first);
        last = userInfo.get("last_name");
        createAccountPage.lastName.sendKeys(last);
         ;
        createAccountPage.password.sendKeys(userInfo.get("password"));
        createAccountPage.chooseDob();
        createAccountPage.address.sendKeys(userInfo.get("Street Address"));
        createAccountPage.city.sendKeys(userInfo.get("City"));
        createAccountPage.chooseState(userInfo.get("State"));
        createAccountPage.zipcode.sendKeys(userInfo.get("Zip Code"));
        createAccountPage.phone.sendKeys(userInfo.get("Phone"));




        createAccountPage.registerButton.click();

    }
}
