package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    private static final logger=LoggerFactory.getLogger(UserService.class);

    @Transactional
    public void saveNewUser(User user) {
        try{
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
        return true;// Use 'entry' here instead of 'journalEntry'
    } catch(Exception e){
        logger.error("Error Occures", e);
        return false;
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
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
