package stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.duotify.Homepage;
import pages.duotify.LoginPage;
import utilities.ConfigReader;
import utilities.DBUtils;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class DbAndUiStepDefs {

    String expectedUsername;
    String expectedFirstName ;
    String expectedLastName ;
    String expectedEmail ;

    String userExpected;
    String updatedEmail;

    @Given("The user is on the homepage and database connection is established")
    public void the_user_is_on_the_homepage_and_database_connection_is_established() {
        Driver.getDriver().get(ConfigReader.getProperty("url2"));
        DBUtils.createConnection();
    }
    @When("The user registers using the following info")
    public void the_user_registers_using_the_following_info(List<Map<String,String>> userInfo) {
        Map<String, String> user = userInfo.get(0);

        LoginPage loginPage = new LoginPage();
        loginPage.signUpLink.click();

         expectedUsername = new Faker().name().username();
        expectedFirstName = user.get("first name");
        expectedLastName = user.get("last name");
         expectedEmail = new Faker().internet().emailAddress();
        String password = user.get("password");

        loginPage.username.sendKeys(expectedUsername);
        loginPage.firstName.sendKeys(expectedFirstName);
        loginPage.lastName.sendKeys(expectedLastName);
        loginPage.email.sendKeys(expectedEmail);
        loginPage.email2.sendKeys(expectedEmail);
        loginPage.password.sendKeys(password);
        loginPage.password2.sendKeys(password);

        loginPage.registerButton.click();

        Assert.assertTrue(Driver.getDriver().getTitle().equals("Welcome to Duotify!"));

    }

    @Then("The same information about the user should be created in the users table in the db")
    public void the_same_information_about_the_user_should_be_created_in_the_users_table_in_the_db() {

        String query = "select * from users where username='"+expectedUsername+"'";
        List<Map<String, Object>> queryResultMap = DBUtils.getQueryResultMap(query);
        Map<String, Object> map = queryResultMap.get(0);

        String actualUsername = (String) (map.get("username"));
        String actualFirstName = (String) (map.get("firstName"));
        String actualLastName = (String) (map.get("lastName"));
        String actualEmail = (String) (map.get("email"));


        Assert.assertEquals(expectedUsername, actualUsername);
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedEmail, actualEmail);




    }




    @When("The user with username {string} and password {string} updates the email on the UI")
    public void the_user_with_username_and_password_updates_the_email_to_on_the_ui(String user, String pass) {
                  userExpected = user;
                  LoginPage loginPage = new LoginPage();
                  loginPage.loginUsername.sendKeys(user);
                  loginPage.loginPassword.sendKeys(pass);
                  loginPage.loginButton.click();

                Homepage homepage = new Homepage();
                homepage.userDetailsLink.click();
                homepage.userDetailsButton.click();

                updatedEmail = homepage.emailInputBox.getAttribute("value").toLowerCase();

                homepage.emailInputBox.clear();

                homepage.emailInputBox.sendKeys(updatedEmail);

                homepage.saveButton.click();


                Assert.assertTrue(homepage.successMessage.isDisplayed());



    }



    @Then("The email database info for the same user should also be updated")
    public void the_email_database_info_for_the_same_user_should_also_be_updated() {
        String query = "select email from users where username='"+userExpected+"'";
        String emailExpected =  (String)(DBUtils.getQueryResultList(query).get(0).get(0));

        Assert.assertEquals(emailExpected, updatedEmail);


    }
}
