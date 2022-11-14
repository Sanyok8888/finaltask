package tests.remaderestassured;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.testng.annotations.Test;
import remadeapitestsdata.RemadeAppleSearchResultDto;
import java.util.Map;

public class RemadeApiTests {


    @Test
    public  void searchByTermCountryParameters() throws JsonProcessingException {
        JsonPath jsonPath =
                RestAssured.given()
                        .header("Content-Type","application/json")
                        .baseUri("https://itunes.apple.com/search")
                        .params(Map.of("term", "Nirvana","country","US"))
                        .get("/search")
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .jsonPath();

        RemadeAppleSearchResultDto remadeAppleSearchResultDto  = new ObjectMapper().readValue(jsonPath.prettyPrint(),RemadeAppleSearchResultDto.class);

        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getWrapperType().equals("track")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getKind().equals("song")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getArtistId() == 156488786));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getCollectionId() == 1444896308));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getTrackId() == 1444896574));


    }



    @Test
    public  void searchByTermCountryMediaParameters() throws JsonProcessingException {
        JsonPath jsonPath =
         RestAssured.given()
                 .header("Content-Type","application/json")
                 .baseUri("https://itunes.apple.com/search")
                 .params(Map.of("term", "Nirvana","country","US","media","music"))
                 .get("/search")
                 .then()
                 .statusCode(200)
                 .extract()
                 .body()
                 .jsonPath();

        RemadeAppleSearchResultDto remadeAppleSearchResultDto  = new ObjectMapper().readValue(jsonPath.prettyPrint(),RemadeAppleSearchResultDto.class);

        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().allMatch(result->result.getWrapperType().equals("track")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().allMatch(result->result.getKind().equals("song")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getArtistId() == 156488786));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getCollectionId() == 1444896308));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getTrackId() == 1444896574));


    }

    @Test
    public  void searchByTermCountryEntityParameters() throws JsonProcessingException {
        JsonPath jsonPath =
                RestAssured.given()
                        .header("Content-Type","application/json")
                        .baseUri("https://itunes.apple.com/search")
                        .params(Map.of("term", "Nirvana","country","US","entity", "movieArtist"))
                        .get("/search")
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .jsonPath();

        RemadeAppleSearchResultDto remadeAppleSearchResultDto  = new ObjectMapper().readValue(jsonPath.prettyPrint(),RemadeAppleSearchResultDto.class);

        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getWrapperType().equals("artist")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getArtistType().equals("Artist")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getArtistName().equals("Nirvana")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getArtistLinkUrl().equals("https://music.apple.com/us/artist/nirvana/112018?uo=4")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getAmgArtistId() == 5034));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getPrimaryGenreName().equals("Alternative")));
        Assert.assertTrue(remadeAppleSearchResultDto.getResults().stream().anyMatch(result->result.getPrimaryGenreId() == 20));


    }

}
