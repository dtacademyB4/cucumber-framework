package stepDefs.ApiTests;

import io.restassured.RestAssured;
import org.junit.Test;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SerializationDemo {

    static {
        RestAssured.baseURI = ConfigReader.getProperty("base_uri");
    }

    @Test
    public void sendPayloadAsMap(){
        //Serialization - process of converting Java Object into a JSON when it is sent through the network
        // Deserialization - process of converting the JSON to Java type

        // Rest Assured does the serialization automatically since it has a built in serializers such as Jackson


        // Send POST request to create an entry
        // Send the payload(body) as Java Map object

        Map<String, Object>  bodyAsMap = new TreeMap<>();

        bodyAsMap.put("id", (int)(Math.random()*Integer.MAX_VALUE));
        bodyAsMap.put("name", "Hitman 47");
        bodyAsMap.put("releaseDate", "2021-06-06T14:24:09.683Z");
        bodyAsMap.put("reviewScore", 90);
        bodyAsMap.put("category", "FPS");
        bodyAsMap.put("rating", "PG13");


        given(). log().all().
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                body(bodyAsMap).
        when(). log().all().
                post("/videogames").
        then(). log().all().
                statusCode(200).
                body("status", is("Record Added Successfully"));





    }












}
