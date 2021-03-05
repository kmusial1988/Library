package library.dao;

import library.model.Author;

import java.util.List;

public interface IAuthorDAO {
    List<Author> findAuthors(String pattern);
}
