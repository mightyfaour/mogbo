package africa.semicolon.eventbrite.services;

import africa.semicolon.eventbrite.data.model.Party;
import africa.semicolon.eventbrite.dto.requests.CreatePartyRequest;

public interface PartyService {

    Party saveParty(Party party);

    void saveparty(CreatePartyRequest createPartyRequest);
}
