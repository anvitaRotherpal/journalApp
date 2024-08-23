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

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;
    private Object myEntry;

    @Autowired
    private UserService userService;

    @GetMapping("userName")
public ResponseEntity<?> getAllJournalEntriesofUser(@PathVariable String userName){
        User user=userService.findByUserName(userName);
        if(all!=null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping("userName")
   public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) {

    try {

        journalEntryService.saveEntry(myEntry, userName);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
    }catch(Exception e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}





@GetMapping("id/{myId}")
public ResponseEntity<JournalEntry> getJournalEntryById(){
        Authentication authentication=SecurityContextHolder.getContext.getAuthentication();
        String username=authentication.getName();
        User user=userService.findByUserName(userName);
      List<JournalEntry> journalEntry= journalEntryService.findById(myId);
      if(all!=null && !all.isEmpty()){
          return new ResponseEntity<>(all,HttpStatus.OK);
    }
    
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}

    @DeleteMapping("id/{username}/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName){
        journalEntryService.deleteById(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{userName}/{myId}")
    public ResponseEntity<Object> updateJournalEntryById(
            @PathVariable ObjectId id;
            @RequestBody JournalEntry newEntry;
            @PathVariable String  userName;
    ){

        JournalEntry old = journalEntryService.findById(myId).orElse(null);

        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && newEntry.getTitle().equals("")? newEntry.getEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent()!=null && newEntry.getContent.equals("") ? newEntry.getContent() : old.getContent());
            journalEntryService.saveEntry(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
}