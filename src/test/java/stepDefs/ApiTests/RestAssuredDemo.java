package stepDefs.ApiTests;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

public class RestAssuredDemo {



    @BeforeClass
    public static void initializeBaseUri(){
        RestAssured.baseURI = "http://localhost:8080/app";
    }


    @Test
    public void testRestAssured(){
        // Rest Assured follows given, when, then style format
        // Given -> represents the request specifications.
                    // headers, authorization (api keys, access tokens),
                     // query/path parameters, body(payload)
        // When -> the type of request to be sent
        // Then -> Assertions happen here

        int gameId = 5;
        given().
                header("Accept", "application/json").
                contentType("application/json").
                pathParam("videoGameId", gameId).
       when().
                get("/videogames/{videoGameId}").
       then(). log().all().
                assertThat().
                statusCode(200).
                body("id", equalTo(gameId)).
                body("name", is("The Legend of Zelda: Ocarina of Time")).
                body("releaseDate", is("1998-12-10")).
                body("reviewScore", is(93)).
                body("category", is("Adventure")).
                body("rating", is("PG-13"));






    }
      // CRUD operations
     // Create - POST
    //  Read - GET
    //  Update - PUT/PATCH
    //  Delete - DELETE


     @Test
    public void testPostVideoGamesEndpoint(){

         int id = 11 + ((int)(Math.random()*Integer.MAX_VALUE));



        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \"Half-Life\",\n" +
                        "  \"releaseDate\": \"1999-06-04T22:17:58.056Z\",\n" +
                        "  \"reviewScore\": 100,\n" +
                        "  \"category\": \"FPS\",\n" +
                        "  \"rating\": \"PG13\"\n" +
                        "}").
                // body(new File("body.json")). // you can also send the body as json file
        when(). log().all().
                post("/videogames").
        then(). log().all().
                assertThat().
                statusCode(200).
                body("status", is("Record Added Successfully"));


    }


    @Test
    public void testPUTrequest(){


        String actual = given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                pathParam("videoGameId", "1").
                body(new File("src/test/java/stepDefs/ApiTests/payloads/putRequestPaylod.json")).
                // body(new File("body.json")). // you can also send the body as json file
                        when().log().all().
                        put("/videogames/{videoGameId}").
                        then().log().all().
                        assertThat().
                        statusCode(200).extract().response().asPrettyString();

        String expected = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Half-Life\",\n" +
                "    \"releaseDate\": \"1999-06-04\",\n" +
                "    \"reviewScore\": 100,\n" +
                "    \"category\": \"FPS\",\n" +
                "    \"rating\": \"PG13\"\n" +
                "}";

        Assert.assertEquals(expected,actual);





    }


    @Test
    public void testDELETErequest(){

    JsonPath response =  given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                pathParam("id", "100").

        when(). log().all().
                delete("/videogames/{id}").
        then(). log().all().
                assertThat().
                statusCode(200).
                body("status", is("Record Deleted Successfully")).
                header("content-length", equalTo("41")).
                header("content-type", is("application/json")).extract().response().jsonPath();


        String name = response.get("status");

        System.out.println(name);
    }






}
