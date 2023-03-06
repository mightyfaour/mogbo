package africa.semicolon.eventbrite.data.repositories;

import africa.semicolon.eventbrite.data.model.Party;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PartyRepository extends MongoRepository<Party, String> {
}
