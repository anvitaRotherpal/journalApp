package net.engineeringdigest.journalApp.service;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.VisibleForTesting;
import net.engineeringdigest.journalApp.Repositories.UserRepository;

import java.util.ArrayList;

import static com.mongodb.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.when;

public class UserServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImp userDetailsService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotation.initMocks(this);

    }

    @Test
    void loadUserByUsernameTest(){
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("ram".password("abfy").roles(new ArrayList<>()).build()));
        UserDetails user=userDetailsService.loadUserByUsername("ram");
        assertNotNull(user);
    }
}
