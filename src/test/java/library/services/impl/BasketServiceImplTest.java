package library.services.impl;/*
package pl.camp.it.library.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.camp.it.library.AppConfigurationTest;
import pl.camp.it.library.dao.IAuthorDAO;
import pl.camp.it.library.dao.IBookDAO;
import pl.camp.it.library.dao.IUserDAO;
import pl.camp.it.library.model.Book;
import pl.camp.it.library.services.IBasketService;
import pl.camp.it.library.session.SessionObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
@WebAppConfiguration

public class BasketServiceImplTest {
    @Autowired
    IBasketService basketService;
    @Autowired
    SessionObject sessionObject;
    @MockBean
    IUserDAO userDAO;
    @MockBean
    IBookDAO bookDAO;
    @MockBean
    IAuthorDAO authorDAO;

    @Before
    public void setUpMocks(){
        Book book = new Book();
        book.setId(5);
        book.setAuthor(null);
        book.setCategory(Book.Category.BAKING);
        book.setTitle("jlsfdgabf");
        book.setIsbn("adfgsdf");



        Mockito.when(this.bookDAO.getBookById(5)).thenReturn(book);
    }
    @Test
    public void  addingUnigueBookToBasketTest(){
        int bookId = 5;
        int expectedResult = 1;
        this.basketService.addBookToBasket(bookId);

        int result = this.sessionObject.getBasket().size();
        Assert.assertEquals(expectedResult, result);


    }

}
*/
