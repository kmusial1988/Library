package library.dao.impl;

import library.dao.IAuthorDAO;
import library.model.Author;

import java.util.List;

public class AuthorDAOStub implements IAuthorDAO {
    @Override
    public List<Author> findAuthors(String pattern) {
        return null;
    }
}
