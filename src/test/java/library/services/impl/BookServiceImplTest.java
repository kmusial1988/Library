package library.services.impl;

import library.AppConfigurationTest;
import library.dao.IAuthorDAO;
import library.dao.IBookDAO;
import library.dao.IUserDAO;
import library.model.Author;
import library.services.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})

public class BookServiceImplTest {

    @Autowired
    IBookService bookService;
    @MockBean
    IUserDAO userDAO;
    @MockBean
    IBookDAO bookDAO;
    @MockBean
    IAuthorDAO authorDAO;




    @Test
    public void checkMethodsCallDuringFindingBooksByPattern(){
        String pattern = "book";

        Mockito.when(this.bookDAO.findBooks(anyString())).thenReturn(new ArrayList<>());

        List<Author> authorList = new ArrayList<>();
        Author a1 = new Author();
        a1.setId(3);
        a1.setName("Tadeusz");
        a1.setSurname("Pan");

        Author a2 = new Author();
        a2.setId(3);
        a2.setName("Tadeusz");
        a2.setSurname("Drozd");

        authorList.add(a1);
        authorList.add(a2);

        Mockito
                .when(this.authorDAO.findAuthors(anyString()))
                .thenReturn(authorList);
        Mockito
                .when(this.bookDAO.findBooks(anyString()))
                .thenReturn(new ArrayList<>());
        this.bookService.findBooks(pattern);

        verify(this.bookDAO, times(1)).findBooks(anyString());

        verify(this.authorDAO, times(1)).findAuthors(anyString());

        verify(this.bookDAO, times(2)).getBooksByAuthorId(anyInt());
    }


}
