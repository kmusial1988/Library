package library.dao;

import library.model.User;

public interface IUserDAO {
    User getUserByLogin(String login);
    void addUser(User user);
}
