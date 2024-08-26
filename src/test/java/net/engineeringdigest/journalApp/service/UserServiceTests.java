package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.entity.UserArgumentsProvider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserServiceTests {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;







    @Test
    public void testFindByUserName() {
        userRepository.findByUserName("ram");


    }


    @ParametrizedTest
    @ArgumentsSource(UserArgumentsProvider.class){
        public void testSaveNewUser(User user){
            assertTrue(userService.saveNewUser(user));
        }
    }

    @Disabled
    @ParametrizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
