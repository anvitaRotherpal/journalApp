package net.engineeringdigest.journalApp.Scheduler;
import net.engineeringdigest.journalApp.Repositories.UserRepository;
import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.EmailService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Scheduled(cron="0 9 * * SUN")
    public void fetchUserAndSendMail(){

        List<User> users=userRepository.getUserforSA();
        for(User user:users){
            List<JournalEntry> journalEntries=user.getJournalEntries();
            List<JournalEntry> filteredEntries=journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getContent().collect(Collectors.toList()));
            String entry=String.join("", filteredEntries);
            int sentiment=sentimentAnalysisService.getSentiment(entry);
            emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days",sentiment);
        }

    }
}
