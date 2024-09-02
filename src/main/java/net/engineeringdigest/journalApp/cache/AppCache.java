package net.engineeringdigest.journalApp.cache;

import net.engineeringdigest.journalApp.Repositories.ConfigJournalAppRepository;
import net.engineeringdigest.journalApp.entity.ConfigJournalAppEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public class AppCache  {

    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;


    private Map<String, String>APP_CACHE;

    @PostConstruct
    public void init() {
        List<ConfigJournalAppEntity> all=configJournalAppRepository.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity:all) {
            APP_CACHE.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }
}
