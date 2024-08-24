package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserName() {
        userRepository.findByUserName("ram");


    }


    @ParametrizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}
