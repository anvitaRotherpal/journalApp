package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.Repositories.ConfigJournalAppRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Map;

public class AppCache  {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;


    private Map<String, String>appCache;

    @PostConstruct
    public void init() {
        appCache=null;
    }
}
