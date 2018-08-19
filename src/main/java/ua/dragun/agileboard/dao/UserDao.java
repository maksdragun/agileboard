package ua.dragun.agileboard.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.dragun.agileboard.entity.User;

public interface UserDao extends MongoRepository<User, String> {
    User findByUsername(String username);
}
