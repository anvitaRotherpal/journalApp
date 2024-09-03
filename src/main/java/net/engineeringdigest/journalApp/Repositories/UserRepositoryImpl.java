package net.engineeringdigest.journalApp.Repositories;

import net.engineeringdigest.journalApp.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;
import java.util.List;

public class UserRepositoryImpl {


    public List<User> getUserForSA{
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is("vipul"));
    }
}
