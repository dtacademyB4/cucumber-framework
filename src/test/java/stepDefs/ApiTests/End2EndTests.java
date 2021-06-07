package stepDefs.ApiTests;

import io.restassured.RestAssured;
import org.junit.Test;
import utilities.ConfigReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class End2EndTests {


    static {
        RestAssured.baseURI = ConfigReader.getProperty("base_uri");
    }



    @Test
    public void createAnEntryTest(){
        // 1. Create a new videogame using post request
        // 2. Verify the video game creation using get request
        // 3. Call put request to update the newly created video game
        // 4. Verify the updated video game values
        // 5. Call delete request to delete the newly created videogame
        // 6. Call get request to verify the deletion of the video game
        int id = (int)(Math.random()*Integer.MAX_VALUE);
        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \"Mario Kart\",\n" +
                        "  \"releaseDate\": \"2020-06-07T14:24:09.683Z\",\n" +
                        "  \"reviewScore\": 90,\n" +
                        "  \"category\": \"Arcade\",\n" +
                        "  \"rating\": \"GA\"\n" +
                        "}").
        when().log().all().
                post("/videogames").
        then().log().all().
                statusCode(200);


        // GET videogame

        given().
                header("Accept", "application/json").
                pathParam("id", id).
                when().log().all().
                get("/videogames/{id}").
                then().log().all().
                statusCode(200).
                body("id", equalTo(id));

        // Update the newly created entry
         String updatedValue = "Zelda";
        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \""+updatedValue+"\",\n" +
                        "  \"releaseDate\": \"2020-06-07T14:24:09.683Z\",\n" +
                        "  \"reviewScore\": 90,\n" +
                        "  \"category\": \"Arcade\",\n" +
                        "  \"rating\": \"GA\"\n" +
                        "}").
                pathParam("id", id).
                when().log().all().
                put("/videogames/{id}").
                then().log().all().
                statusCode(200).
                body("name", equalTo(updatedValue));

        // Get the updated entry to verify

        given().
                header("Accept", "application/json").
                pathParam("id", id).
                when().log().all().
                get("/videogames/{id}").
                then().log().all().
                statusCode(200).
                body("name", equalTo(updatedValue));


        // Delete the newly created entry

        given().
                header("Accept", "application/json").
                pathParam("id", id).
                when().log().all().
                delete("/videogames/{id}").
                then().log().all().
                statusCode(200).
                body("status", equalTo("Record Deleted Successfully"));

        // Get the deleted entry and verify that it does not exist

        given().
                header("Accept", "application/json").
                pathParam("id", id).
                when().log().all().
                get("/videogames/{id}").
                then().log().all().
                statusCode(not(200)).
                body("status", equalTo(500));











    }
}
