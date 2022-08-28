package remadeapitestsdata;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Jacksonized
@Data
public class RemadeAppleSearchResultDto {
    private int resultCount;
    private List<RemadeAppleDto> results;
}
