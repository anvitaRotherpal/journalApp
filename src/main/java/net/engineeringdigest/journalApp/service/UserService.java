package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.JournalEntryRepository;
import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user) {
        journalEntry.setDate(LocalDateTime.now());
        userRepository.save(user);  // Use 'entry' here instead of 'journalEntry'
    }


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }
}
