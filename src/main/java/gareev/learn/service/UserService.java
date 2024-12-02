package gareev.learn.service;

import gareev.learn.domain.User;
import gareev.learn.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    final private UserDao dao;

    public UserService(@Autowired UserDao dao) {
        this.dao = dao;
    }

    public Long countUsers() {
        return dao.count();
    }

    public User createJohnJohn() {
        User user = new User();
        user.setName("JohnJohn");
        user.setAge(20);
        user.setBirthDate(LocalDate.now().minusYears(20));
        user = dao.createUser(user);
        return user;
    }

    public List<User> getAllUsers() {
        return dao.getUsers();
    }
}
