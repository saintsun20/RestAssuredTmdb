package TMDB;

import TMDB.Utility.ConfigReader;
import TMDB.Utility.TMDB_ParentPage;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Movies extends TMDB_ParentPage {

    @Test
    public void details() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/" + ConfigReader.getProperty("MovieID"))
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void lists() {

        given()
                .spec(reqSpec)
                .when()
                .get("movie/" + ConfigReader.getProperty("MovieID") + "/lists")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void addRating() {

        Map<String, String> addRating = new HashMap<>();
        addRating.put("value", "8,5");

        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(addRating)
                .when()
                .post("movie/" + ConfigReader.getProperty("MovieID") + "/rating")
                .then()
                .log().body()
                .statusCode(201)
                .body("status_message", containsStringIgnoringCase("success"));
    }

    @Test
    public void deleteRating() {

        given()
                .spec(reqSpec)
                .when()
                .delete("movie/" + ConfigReader.getProperty("MovieID") + "/rating")
                .then()
                .log().body()
                .statusCode(200)
                .body("status_message", containsStringIgnoringCase("deleted successfully"));
    }

    @Test
    public void addMovie() {

        Map<String, String> addMovie = new HashMap<>();
        addMovie.put("media_id", "18");

        given()
                .spec(reqSpec)
                .contentType(ContentType.JSON)
                .body(addMovie)
                .when()
                .post("list/" + ConfigReader.getProperty("ListID") + "/add_item?session_id=347856")
                .then()
                .log().body()
                .statusCode(401)
                .body("status_message", containsStringIgnoringCase("You do not have permissions"));
    }
}