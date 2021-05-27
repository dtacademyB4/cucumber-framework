package stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class DBOnlyStepDefs {

    String expectedEmail;

    List<List<Object>> actualListFromDb;
    List<String> actual;
    @When("I send a query")
    public void i_send_a_query() {
       actualListFromDb = DBUtils.getQueryResultList("select name from genres");


    }

    @Then("The following genres should be returned")
    public void the_following_genres_should_be_returned( List<String> expectedList) {
         List<String> actual = new ArrayList<>();
        for (List<Object> s : actualListFromDb) {
            actual.add((String) (s.get(0)));
        }

        Assert.assertEquals(expectedList, actual);



    }

    @When("I send a request to retrieve the column names for users table")
    public void i_send_a_request_to_retrieve_the_column_names_for_users_table() {

        actual = DBUtils.getColumnNames("select * from users limit 1");

    }
    @Then("The result should be the following")
    public void the_result_should_be_the_following(List <String> expected) {

        Assert.assertEquals(actual, expected);
    }


    @When("I send and update statement to modify email for user with id {int} to {string}")
    public void i_send_and_update_statement_to_modify_email_for_user_with_id_to(Integer id, String email) {
        expectedEmail = email;

        String query = "update users set email=\""+expectedEmail+"\" where id="+id;
        DBUtils.updateQuery(query);

    }

    @Then("I should see the updated email {string} for the user with id {int}")
    public void i_should_see_the_updated_email_for_the_user_with_id(String string, Integer id) {

        String query = "select email from users where id="+id;
        List<List<Object>> queryResultList = DBUtils.getQueryResultList(query);

        String actualEmail = (String)(queryResultList.get(0).get(0));

        Assert.assertEquals(expectedEmail, actualEmail);


    }



}
