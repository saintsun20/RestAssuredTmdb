package TMDB.Utility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.baseURI;

public class TMDB_ParentPage {
   public RequestSpecification reqSpec;

    @BeforeClass
    public void SetUp() {
        baseURI = "https://api.themoviedb.org/3/";

        reqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", ConfigReader.getProperty("bearerToken"))
                .setContentType(ContentType.JSON)
                .build();
    }
}
