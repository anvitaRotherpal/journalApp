package net.engineeringdigest.journalApp.Scheduler;
import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.service.EmailService;
import org.springframework.stereotype.Component;



@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void fetchUserAndSendMail(){

        @Autowired
        EmailService emailService ;
    }
}
