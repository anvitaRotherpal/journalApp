package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;
    private Object myEntry;

    @Autowired
    private UserService userService;

    @GetMapping("userName")
public ResponseEntity<?> getAllJournalEntriesofUser(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=userService.findByUserName(userName);
        User user=userService.findByUserName(userName);
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping("userName")
   public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {

    try {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String userName=userService.findByUserName(userName);

        journalEntryService.saveEntry(myEntry, userName);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}





@GetMapping("id/{myId}")
public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication=SecurityContextHolder.getContext.getAuthentication();
        String username=authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> collect=users.getJournalEntries().stream().filter(x -> x.getId().equals(myId).collect(Collectors.toList()));
        if(!collect.isEmpty()){
           Optional<JournalEntry> journalEntry= journalEntryService.findById(myId);
        }
      List<JournalEntry> journalEntry= journalEntryService.findById(myId);
      if(journalEntry.isPresent()){
          return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
    }
    
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

    @DeleteMapping("id/{username}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
        Authentication authentication=SecurityContextHolder.getContext.getAuthentication();
        String username=authentication.getName();
        boolean removed=journalEntryService.deleteById(myId,username);
        if(removed){
            return new ResponseEntity<>(HttpStatus.OK);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/id/{myId}")
    public ResponseEntity<Object> updateJournalEntryById(@PathVariable ObjectId id,@RequestBody JournalEntry newEntry)

    {
        Authentication authentication=SecurityContextHolder.getContext.getAuthentication();
        String username=authentication.getName();
        User user=userService.findByUserName(userName);
        List<JournalEntry> collect=users.getJournalEntries().stream().filter(x -> x.getId().equals(myId).collect(Collectors.toList()));
        if(!collect.isEmpty()){
            Optional<JournalEntry> old=journalEntryService.findById(myId);
            if(journalEntry.isPresent()){
                JournalEntry old=journalEntry.get();
                old.setTitle(newEntry.getTitle()!=null && newEntry.getTitle().equals("")? newEntry.getEntry.getTitle() : old.getTitle());
                old.setContent(newEntry.getContent()!=null && newEntry.getContent.equals("") ? newEntry.getContent() : old.getContent());
                journalEntryService.saveEntry(old);
                return new ResponseEntity<>(old, HttpStatus.OK);
            }

        }



           ;


        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
}