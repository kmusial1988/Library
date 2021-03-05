package library.services;

import library.model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    List<Book> getAllBooks();
    List<Book> findBooks(String pattern);
    List<Book> getBooksByCategory(Book.Category category);
}
