package TMDB;

import TMDB.Utility.TMDB_ParentPage;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Search extends TMDB_ParentPage {

    @Test
    public void movie() {

        given()
                .spec(reqSpec)
                .when()
                .get("search/movie?Query=Hot Frosty")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void TV() {

        given()
                .spec(reqSpec)
                .when()
                .get("search/tv?Query=The Rookie")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void person() {

        given()
                .spec(reqSpec)
                .when()
                .get("search/person?Query=Scarlett Johansson")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void keyword() {

        given()
                .spec(reqSpec)
                .when()
                .get("search/keyword?Query=Movie")
                .then()
                .log().body()
                .statusCode(200);
    }
}
