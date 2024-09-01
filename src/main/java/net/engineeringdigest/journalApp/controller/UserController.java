package net.engineeringdigest.journalApp.controller;


import net.engineeringdigest.journalApp.api.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherService weatherService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication=SecurityContextHolder.getContext.getAuthentication();
        String userName=authentication.getName();
        User userInDb=userService.findByUserName(userName);
      userInDb=userService.findByUserName(user.getUserName());
      if(userInDb!=null){
          userInDb.setUser(user.getUserName());
          userInDb.setPassword(user.getPassword());
          userService.saveNewUser(userInDb);

      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

      @DeleteMapping("/user")
              public ResponseEntity<?> deleteUserById() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userRepository.deleteByUserName(authentication.getName());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping Mapping
        public ResponseEntity<?> greeting() {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            userRepository.deleteByUserName(authentication.getName());
            WeatherResponse mumbai=weatherService.getWeather("Mumbai");
            String greeting="";
            if(weatherResponse!=null){
            greeting=",Weather feels like"+weatherResponse.getCurrent().getFeelslike();
            }
        }
            return new ResponseEntity<>("Hi"+authentication.getName() + greeting, HttpStatus.OK);
        }

      }










