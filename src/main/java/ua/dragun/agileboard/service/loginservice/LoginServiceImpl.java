package ua.dragun.agileboard.service.loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dragun.agileboard.dao.user.UserDao;
import ua.dragun.agileboard.entity.user.User;
import ua.dragun.agileboard.service.enums.LoginStatus;

import java.util.List;
import java.util.regex.Pattern;


@Service
public class LoginServiceImpl implements LoginService {

    private final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z]{3,}$");
    private final Pattern PASSWORD_PATTERN = Pattern.compile("^[A-Za-z0-9]{5,}$");

    @Autowired
    private UserDao userDao;

  /*  @Autowired
    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }*/

    @Override
    public User findByUsername(String username) {
        List<User> list = (List<User>) userDao.findAll();
        for(User users : list) {
            if(users.getUsername().equalsIgnoreCase(username))
                return users;
        }
        return null;
    }

    @Override
    public LoginStatus create(String username, String password, String fullName) {
        List<User> list = (List<User>) userDao.findAll();
        for(User users : list) {
            if(users.getUsername().equalsIgnoreCase(username))
                return LoginStatus.ALREADY_EXISTS;
        }
        if( !USERNAME_PATTERN.matcher(username).matches() ) {
            return LoginStatus.INCORRECT_USERNAME;
        } else if ( !PASSWORD_PATTERN.matcher(password).matches() ) {
            return LoginStatus.INCORRECT_PASSWORD;
        } else if ( fullName.length() < 5 ) {
            return LoginStatus.INCORRECT_FULLNAME;
        } else {
            User user = new User(username, password, fullName);
            userDao.save(user);
            return LoginStatus.SUCCESS;
        }
    }
}
