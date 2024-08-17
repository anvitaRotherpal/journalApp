package net.engineeringdigest.journalApp.Repositories;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

    Optional<JournalEntry> findById(ObjectId id);
}
