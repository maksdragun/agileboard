package ua.dragun.agileboard.service.loginservice;

import ua.dragun.agileboard.entity.user.User;
import ua.dragun.agileboard.service.enums.LoginStatus;

public interface LoginService {

    User findByUsername(String username);
    LoginStatus create(String username, String password, String fullName);
}
