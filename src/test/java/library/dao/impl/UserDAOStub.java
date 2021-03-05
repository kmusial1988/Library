package library.dao.impl;

import library.dao.IUserDAO;
import library.model.User;

public class UserDAOStub implements IUserDAO{

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        user.setId(4);
        user.setLogin("user");
        user.setPassword("user");

        return user;
    }

    @Override
    public void addUser(User user) {


    }
}
