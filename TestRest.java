import com.google.gson.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRest {

    @Test
    public void Test1(){
        Response response = null;
        String uri = "https://jsonplaceholder.typicode.com/posts";

        response = RestAssured.given()
                .relaxedHTTPSValidation()
                //.header("Content-Type", "application/json")
                .when()
                .get(uri);
        assertEquals(200, response.getStatusCode());
    }
    @Test
            public void Test2(){
        Response response = null;
        String uri = "https://jsonplaceholder.typicode.com/albums";

        response = RestAssured.given()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .when()
                //.then()
                .get(uri);


        JsonArray array = response.getBody().as(JsonArray.class);
        Integer obj = array.size();
        assertEquals(100, obj);
    }
}
