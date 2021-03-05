package library.services.impl;

import library.AppConfigurationTest;
import library.dao.IAuthorDAO;
import library.dao.IBookDAO;
import library.dao.IUserDAO;
import library.model.User;
import library.services.IUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfigurationTest.class})
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @MockBean
    IUserDAO userDAO;
    @MockBean
    IAuthorDAO authorDAO;
    @MockBean
    IBookDAO bookDAO;

    @Before
    public void setUpMocks(){
        User user = new User();
        user.setId(5);
        user.setLogin("Mateusz");
        user.setPassword("fhgblsdf");

        Mockito.when(this.userDAO.getUserByLogin("mateusz")).thenReturn(user);

        user = new User();
        user.setId(5);
        user.setLogin("admin");
        user.setPassword("fhgblsdf");

        Mockito.when(this.userDAO.getUserByLogin("admin")).thenReturn(user);

        Mockito.when(userDAO.getUserByLogin("badLogin")).thenReturn(null);

    }


    @Test
    public void wrongPasswordAuthenticationTest(){
        /*Mockito.when(this.userDAO.getUserByLogin(anyString()))
                .thenReturn(generateUser("mateusz", "mateusz", 5));*/
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);

    }
    @Test
    public void correctAuthenticationTest(){
       /* Mockito.when(this.userDAO.getUserByLogin(anyString()))
                .thenReturn(generateUserHashPassword("kamil","admin", 5));*/
        User user = new User();
        user.setLogin("kamil");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);
    }
    @Test
    public void wrongLoginAuthenticationTest(){
        User user = new User();
        user.setLogin("badLogin");
        user.setPassword("admin");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);
    }
    @Test
    public void wrongRepeatedPasswordDuringRegistrationTest(){
        User user = new User();
        user.setLogin("janusz");
        user.setPassword("janusz");
        String repeatedPassword = "janusz2";


        boolean result = userService.registerUser(user,repeatedPassword);

        Assert.assertFalse(result);
    }
    @Test
    public void correctRepeatedPasswordDuringRegistrationTest(){
        User user = new User();
        user.setLogin("janusz");
        user.setPassword("janusz");
        String repeatedPassword = "janusz";


        boolean result = userService.registerUser(user,repeatedPassword);

        Assert.assertTrue(result);
        verify(this.userDAO,times(1)).addUser(any());

    }























   /* private User generateUser(String login, String hashedPass, int id){
        User user = new User();
        user.setLogin(login);
        user.setPassword(hashedPass);
        user.setId(id);
        return user;
    }
    private User generateUserHashPassword(String login, String pass, int id){
        User user = new User();
        user.setLogin(login);
        user.setPassword(DigestUtils.md5Hex(pass));
        user.setId(id);
        return user;
    }
*/









}
