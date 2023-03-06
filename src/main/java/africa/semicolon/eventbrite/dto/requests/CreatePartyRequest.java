package africa.semicolon.eventbrite.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreatePartyRequest {
    private String email;
    private String PartyName;
    private String partyLocation;
}
