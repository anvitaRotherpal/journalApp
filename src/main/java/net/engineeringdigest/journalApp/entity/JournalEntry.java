package net.engineeringdigest.journalApp.entity;


import com.mongodb.lang.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="journal_entries")

public class JournalEntry {

    @Id
    private String id;
    @NonNull
    private String title;

    private String content;

    private Date date;


}
