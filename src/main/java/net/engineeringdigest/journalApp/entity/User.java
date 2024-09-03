package net.engineeringdigest.journalApp.entity;


import com.mongodb.lang.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")

public class User {

    @Id
    private ObjectId id;

    @Indexed(unique=true)
    @NonNull
    private String userName;
    private String email;
    private boolean sentimentalAnalysis;
    @NonNull
    private String password;

    @DBRef
    private List<JournalEntry> journalEntries= new ArrayList<>();
    private List<String> roles;


}
