package net.engineeringdigest.journalApp.Repositories;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<JournalEntry, String> {

    User findByUser(String username);
}
