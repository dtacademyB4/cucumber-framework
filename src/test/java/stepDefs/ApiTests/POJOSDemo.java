package stepDefs.ApiTests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import stepDefs.ApiTests.pojos.VideoGame;
import utilities.ConfigReader;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class POJOSDemo {


    //Pojo -> Plain Old Java Object

    static {
        RestAssured.baseURI = ConfigReader.getProperty("base_uri");
    }


    @Test
    public void sendPayloadAsPOJO(){


        //

        VideoGame videoGame = new VideoGame(12, "Mortal Kombat", "1996", 97, "Arcade", "PG13");

        given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGame).
        when(). log().all().
                post("/videogames").
        then(). log().all().
                statusCode(200).
                body("status", is("Record Added Successfully"));







    }

    @Test
    public void receiveResponseBodyAsPOJO(){

        VideoGame videoGame = new VideoGame(10, "Need For Speed", "2020-06-07T14:24:09.683Z", 98, "Driving", "GA");

        VideoGame responseObject = given().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(videoGame).
                pathParam("id", 10).
                when().log().all().
                put("/videogames/{id}").
                then().log().all().
                statusCode(200).extract().response().as(VideoGame.class);

        Assert.assertEquals(videoGame.getId(), responseObject.getId());
        Assert.assertEquals(videoGame.getName(), responseObject.getName());
        Assert.assertEquals(videoGame.getReleaseDate(), responseObject.getReleaseDate()+"T14:24:09.683Z");
        Assert.assertEquals(videoGame.getReviewScore(), responseObject.getReviewScore());
        Assert.assertEquals(videoGame.getCategory(), responseObject.getCategory());
        Assert.assertEquals(videoGame.getRating(), responseObject.getRating());


    }

}
