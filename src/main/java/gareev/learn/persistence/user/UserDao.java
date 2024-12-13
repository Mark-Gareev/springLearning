package gareev.learn.persistence.user;

import gareev.learn.domain.User;

import java.util.List;

public interface UserDao {
    Long count();
    List<User> getUsers();
    User findUserById(Long id);
    User createUser(User user);


}
