package apitestdata.appledto;

import lombok.*;

@Data
//@Builder

public class AppleDto {

    private String wrapperType;
    private String kind;
    private int resultCount;
    private int artistId;
    private int collectionId;
    private int trackId;

    private String trackName;
    private String collectionCensoredName;
    private String trackCensoredName;

    private String artistType;
    private String artistName;
    private String artistLinkUrl;
    private int amgArtistId;
    private String primaryGenreName;
    private int primaryGenreId;


    public AppleDto(String wrapperType,String kind,int resultCount, int artistId, int collectionId, int trackId) {
        this.wrapperType = wrapperType;
        this.kind = kind;
        this.resultCount = resultCount;
        this.artistId = artistId;
        this.collectionId = collectionId;
        this.trackId = trackId;
    }

    public AppleDto(int resultCount,String trackName,String collectionCensoredName,String trackCensoredName){
        this.resultCount = resultCount;
        this.trackName = trackName;
        this.collectionCensoredName = collectionCensoredName;
        this.trackCensoredName = trackCensoredName;
    }

    public AppleDto(int resultCount,String wrapperType, String artistType, String artistName, String artistLinkUrl, int artistId, int amgArtistId,String primaryGenreName,int primaryGenreId){
        this.resultCount = resultCount;
        this.wrapperType = wrapperType;
        this.artistType = artistType;
        this.artistName = artistName;
        this.artistLinkUrl = artistLinkUrl;
        this.artistId = artistId;
        this.amgArtistId = amgArtistId;
        this.primaryGenreName = primaryGenreName;
        this.primaryGenreId = primaryGenreId;
    }

}
