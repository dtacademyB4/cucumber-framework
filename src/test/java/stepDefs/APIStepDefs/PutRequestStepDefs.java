package stepDefs.APIStepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import stepDefs.ApiTests.pojos.VideoGame;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PutRequestStepDefs {

    RequestSpecification requestSpecification;
    Response put;
    VideoGame videoGame;

    @Given("The user passes the following info for POJO")
    public void the_user_passes_the_following_info_for_pojo(List<Map<String, Object>> dataTable) {

        Map<String, Object> row = dataTable.get(0);


        videoGame = new VideoGame(new Integer((String)row.get("id")),
                (String) row.get("name"),
                (String)row.get("release"),
                new Integer((String)row.get("score")),
                (String)row.get("category"),
                (String)row.get("rating"));

       requestSpecification = given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGame).
                pathParam("id", new Integer((String)row.get("id")));


    }
    @When("The user sends PUT request to the endpoint")
    public void the_user_sends_put_request_to_the_endpoint() {

        put = requestSpecification.when().log().all().
                put("/videogames/{id}");


    }
    @Then("The status code should be {int} and the same info must be returned as a POJO")
    public void the_status_code_should_be_and_the_same_info_must_be_returned_as_a_pojo(Integer int1) {
        VideoGame responseObject = put.then().log().all().
                statusCode(200).extract().response().as(VideoGame.class);

        Assert.assertEquals(videoGame.getId(), responseObject.getId());
        Assert.assertEquals(videoGame.getName(), responseObject.getName());

        Assert.assertEquals(videoGame.getReviewScore(), responseObject.getReviewScore());
        Assert.assertEquals(videoGame.getCategory(), responseObject.getCategory());
        Assert.assertEquals(videoGame.getRating(), responseObject.getRating());

    }
}
