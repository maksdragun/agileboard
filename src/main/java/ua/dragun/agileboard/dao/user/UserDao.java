package ua.dragun.agileboard.dao.user;

import org.springframework.data.repository.CrudRepository;
import ua.dragun.agileboard.entity.user.User;

public interface UserDao extends CrudRepository<User, String>  {

}
