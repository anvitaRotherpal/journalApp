package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.JournalEntryRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository  journalEntryRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userService.saveUser(user);// Use 'entry' here instead of 'journalEntry'
        }catch(Exception e){
            System.out.println(e);
            throw new RuntimeException("An error occures while saving the entry", e);
    }
    }

    public void saveEntry(JournalEntry journalEntry) {

         userService.saveNewUser(journalEntry);
    }


    public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id) {
       boolean removed=false;
        try{
        User user=userService.findUserName(userName);
        boolean removed=user.getJournalEntries().remove(x-> x.getId().equals(id));
        if(removed) {
            userService.saveUser(user);
            journalEntryRepository.deleteById(id);
        }

        catch(Exception e){
            log.error("Error",e);
            throw new RuntimeException("An error occures while removing the entry");
            }
            return removed;

    }
}
