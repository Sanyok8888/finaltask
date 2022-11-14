package remadeapitestsdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Jacksonized
public class RemadeAppleDto {

    private String wrapperType;
    private String kind;
    private long artistId;
    private long collectionId;
    private long trackId;
    private String artistType;
    private String artistName;
    private String artistLinkUrl;
    private int amgArtistId;
    private String primaryGenreName;
    private int primaryGenreId;



}
