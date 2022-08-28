package tests.restassured;

import apitestdata.appledto.AppleDto;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import apitestdata.AppleApi;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AppleApiTest {


    @Test
    public void searchByTermAndCountryParameter() {
        AppleApi appleApi = new AppleApi();
        Response getSearchResponse = appleApi.searchByParameters(Map.of("term", "Nirvana", "country", "US"));
        AppleDto appleDto = new AppleDto("track", "song", 50, 156488786, 1444896308, 1444896574);

        assertThat(200).isEqualTo(getSearchResponse.statusCode());
        assertThat(appleDto.getResultCount()).isEqualTo(getSearchResponse.jsonPath().get("resultCount"));
        assertThat(appleDto.getWrapperType()).isEqualTo(getSearchResponse.jsonPath().get("results[0].wrapperType"));
        assertThat(appleDto.getKind()).isEqualTo(getSearchResponse.jsonPath().get("results[0].kind"));
        assertThat(appleDto.getArtistId()).isEqualTo(getSearchResponse.jsonPath().get("results[0].artistId"));
        assertThat(appleDto.getCollectionId()).isEqualTo(getSearchResponse.jsonPath().get("results[0].collectionId"));
        assertThat(appleDto.getTrackId()).isEqualTo(getSearchResponse.jsonPath().get("results[0].trackId"));


    }

    @Test
    public void searchByTermCountryMediaParameters() {
        AppleApi appleApi = new AppleApi();
        Response getSearchResponse = appleApi.searchByParameters(Map.of("term", "Eminem", "country", "US", "media", "music"));
        AppleDto appleDto = new AppleDto(50, "Love the Way You Lie (feat. Rihanna)", "Recovery (Deluxe Edition)", "Love the Way You Lie (feat. Rihanna)");

        assertThat(200).isEqualTo(getSearchResponse.statusCode());
        assertThat(appleDto.getResultCount()).isEqualTo(getSearchResponse.jsonPath().get("resultCount"));
        List<Object> trackNameList = getSearchResponse.jsonPath().getList("results.trackName");
        assertTrue(trackNameList.size() > 0);
        String trackName = appleDto.getTrackName();
        assertTrue(trackNameList.contains(trackName));
        for (int i = 0; i < trackNameList.size(); i++) {
            if (trackNameList.get(i).equals(trackName)) {
                assertThat(appleDto.getTrackName()).isEqualTo(getSearchResponse.jsonPath().getList("results.trackName").get(i));
                assertThat(appleDto.getCollectionCensoredName()).isEqualTo(getSearchResponse.jsonPath().getList("results.collectionCensoredName").get(i));
                assertThat(appleDto.getTrackCensoredName()).isEqualTo(getSearchResponse.jsonPath().getList("results.trackCensoredName").get(i));
            }
        }
    }

    @Test
    public void searchByTermCountryEntityParameters() {
        AppleApi appleApi = new AppleApi();
        Response getSearchResponse = appleApi.searchByParameters(Map.of("term", "Eminem", "country", "US", "entity", "movieArtist"));
        AppleDto appleDto = new AppleDto(2, "artist", "Artist", "Eminem", "https://music.apple.com/us/artist/eminem/111051?uo=4", 111051, 347307, "Hip-Hop/Rap", 18);

        assertThat(200).isEqualTo(getSearchResponse.statusCode());
        assertThat(appleDto.getResultCount()).isEqualTo(getSearchResponse.jsonPath().get("resultCount"));
        List<Object> artistIdList = getSearchResponse.jsonPath().getList("results.artistId");
        assertTrue(artistIdList.size() > 0);
        int artistId = appleDto.getArtistId();
        for (int i = 0; i < artistIdList.size(); i++) {
            if (artistIdList.get(i).equals(artistId)) {
                assertThat(appleDto.getWrapperType()).isEqualTo(getSearchResponse.jsonPath().getList("results.wrapperType").get(i));
                assertThat(appleDto.getArtistType()).isEqualTo(getSearchResponse.jsonPath().getList("results.artistType").get(i));
                assertThat(appleDto.getArtistName()).isEqualTo(getSearchResponse.jsonPath().getList("results.artistName").get(i));
                assertThat(appleDto.getArtistLinkUrl()).isEqualTo(getSearchResponse.jsonPath().getList("results.artistLinkUrl").get(i));
                assertThat(appleDto.getArtistId()).isEqualTo(getSearchResponse.jsonPath().getList("results.artistId").get(i));
                assertThat(appleDto.getAmgArtistId()).isEqualTo(getSearchResponse.jsonPath().getList("results.amgArtistId").get(i));
                assertThat(appleDto.getPrimaryGenreName()).isEqualTo(getSearchResponse.jsonPath().getList("results.primaryGenreName").get(i));
                assertThat(appleDto.getPrimaryGenreId()).isEqualTo(getSearchResponse.jsonPath().getList("results.primaryGenreId").get(i));
            }
        }

    }

}


