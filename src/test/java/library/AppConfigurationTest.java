package library;

import library.session.SessionObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
@ComponentScan(basePackages = {"library.controllers",
                               "library.services"
                               })
public class AppConfigurationTest {
    /*@Bean
    public IUserDAO userDAO(){
        return Mockito.mock(IUserDAO.class);
    }
    @Bean
    public IBookDAO bookDAO(){
        return Mockito.mock(IBookDAO.class);
    }
    @Bean
    public IAuthorDAO authorDAO(){
        return Mockito.mock(IAuthorDAO.class);
    }*/
    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }

}
