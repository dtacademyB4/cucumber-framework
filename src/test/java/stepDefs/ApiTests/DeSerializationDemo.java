package stepDefs.ApiTests;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Test;
import utilities.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;






public class DeSerializationDemo {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("base_uri");
    }





    @Test
    public void receiveResponseAsMap(){


      Map<String, Object> responseAsMap = given().
                header("Accept", "application/json").
                pathParam("id", 1).
                when().log().all().
                get("/videogames/{id}").
                then().log().all().
                statusCode(200).
                body("id", equalTo(1)).extract().response().as(Map.class);


        Assert.assertEquals("Shooter", (responseAsMap.get("category")));
        Assert.assertEquals(85.0,  (responseAsMap.get("reviewScore")));




    }


}
