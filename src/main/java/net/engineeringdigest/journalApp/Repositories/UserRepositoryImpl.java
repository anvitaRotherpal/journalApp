package net.engineeringdigest.journalApp.Repositories;

import net.engineeringdigest.journalApp.entity.User;
import org.springframework.data.mongodb.core.query.Criteria;

import javax.management.Query;
import java.util.List;

public class UserRepositoryImpl {


    public List<User> getUserForSA{
        Query query=new Query();
         Criteria criteria=new Criteria();
         query.addCriteria(criteria.andOperator(
                 Criteria.where("email").exists(true),
                 Criteria.where("sentimentalAnalysis").is(true)
         ));

        List<User> users=mongoTemplate.find(query, User.class);
        return users;
    }
}
