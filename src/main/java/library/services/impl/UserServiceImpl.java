package library.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library.dao.IUserDAO;
import library.model.User;
import library.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public boolean authenticate(User user) {
        User userFormDataBase = userDAO.getUserByLogin(user.getLogin());

        if(userFormDataBase == null) {
            return false;
        }

        if(DigestUtils.md5Hex(user.getPassword())
                .equals(userFormDataBase.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean registerUser(User user, String repeatedPassword) {
        if(!user.getPassword().equals(repeatedPassword)) {
            return false;
        }

        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        this.userDAO.addUser(user);
        return true;
    }
}
