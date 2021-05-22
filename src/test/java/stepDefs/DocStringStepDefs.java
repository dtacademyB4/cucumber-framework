package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocStringStepDefs {

    @Given("The API endpoint is up and running")
    public void the_api_endpoint_is_up_and_running() {

    }

    @When("I send post request by passing this body")
    public void i_send_post_request_by_passing_this_body(String docString) {
        System.out.println(docString);
    }

    @Then("The response should be correct")
    public void the_response_should_be_correct() {

    }

}
