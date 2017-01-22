package com.linoge.servicies.implementations;

import com.linoge.models.entities.User;
import com.linoge.models.enums.Role;
import com.linoge.dao.UserDAO;
import com.linoge.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Tim on 09.01.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Override
    public void createUser(String userName, String password) {
        User user = User.builder()
                .username(userName)
                .password(new BCryptPasswordEncoder().encode(password))
                .accountNonLocked(true)
                .authorities(Arrays.asList(Role.ROLE_ADMIN,
                        Role.ROLE_USER))
                .build();
        userDAO.saveAndFlush(user);
    }
}
