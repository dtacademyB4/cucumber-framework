package stepDefs.APIStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetRequestStepDefs {

    RequestSpecification requestSpecification;
    Response response;


    @Given("The base uri is initialized")
    public void the_base_uri_is_initialized() {

        RestAssured.baseURI = ConfigReader.getProperty("base_uri");



    }
    @Given("The header is {string} and {string} and Video game id is {int}")
    public void the_header_is_and(String key, String value, Integer id) {

        requestSpecification =

                given().   // Request specifications
                header(key, value).
                pathParam("videoGameId", id);


    }

    @When("The user sends GET request to the endpoint")
    public void the_user_sends_get_request_to_the_endpoint() {
        response =
                requestSpecification.when().
                get("/videogames/{videoGameId}");


    }
    @Then("The response status code should be {int} and response body should be correct for video game with id {int}")
    public void the_response_should_be_correct_for_video_game_with_id(Integer statusCode, Integer id) {
        response.then(). log().all().
                assertThat().
                statusCode(statusCode).
                body("id", equalTo(id)).
                body("name", is("Resident Evil 4")).
                body("releaseDate", is("2005-10-01")).
                body("reviewScore", is(85)).
                body("category", is("Shooter")).
                body("rating", is("Universal"));

    }
}
