package TMDB;

import TMDB.Utility.TMDB_ParentPage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Genres extends TMDB_ParentPage {

    @Test
    public void moveList() {

        given()
                .spec(reqSpec)
                .when()
                .get("genre/movie/list")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void tvList() {

        given()
                .spec(reqSpec)
                .when()
                .get("genre/tv/list")
                .then()
                .statusCode(200);
    }
}