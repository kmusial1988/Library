package library.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import library.model.Author;
import library.model.Book;
import library.model.User;
import library.services.IBookService;
import library.services.IUserService;

@Controller
@RequestMapping(value = "/admin/utils")
public class AdminController {

    @Autowired
    IUserService userService;

    @Autowired
    IBookService bookService;

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User();
        user.setLogin("kamil");
        String hashedPassword = DigestUtils.md5Hex("kamil");
        user.setPassword(hashedPassword);

        userService.addUser(user);

        return "redirect:/login";
    }

    @RequestMapping(value = "/addBooks", method = RequestMethod.GET)
    public String addBooks() {
        Book book1 = new Book();
        book1.setIsbn("374563SG");
        book1.setTitle("Sekrety włoskiej kuchni. Dlaczego Włosi lubią rozmawiać o jedzeniu?");
        book1.setCategory(Book.Category.COOKING);

        Author author1 = new Author();
        author1.setName("Elena");
        author1.setSurname("Kostiukovitch");

        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setIsbn("8735687SDFGSD");
        book2.setTitle("Chleb. Techniki wypieku, przepisy, wskazówki.");
        book2.setCategory(Book.Category.COOKING);

        Author author2 = new Author();
        author2.setName("Jeffrey");
        author2.setSurname("Hamelman");

        book2.setAuthor(author2);

        Book book3 = new Book();
        book3.setIsbn("8746sdfg745");
        book3.setTitle("Lunchbox na każdy dzień. Przepisy inspirowane japońskim bento.");
        book3.setCategory(Book.Category.COOKING);

        Author author3 = new Author();
        author3.setName("Malwina");
        author3.setSurname("Bareła");

        book3.setAuthor(author3);

        Book book4 = new Book();
        book4.setIsbn("27635DFG263");
        book4.setTitle("Moje wypieki i desery");
        book4.setCategory(Book.Category.BAKING);

        Author author4 = new Author();
        author4.setName("Dorota");
        author4.setSurname("Świątkowska");

        book4.setAuthor(author4);

        Book book5 = new Book();
        book5.setIsbn("346853shgdf476");
        book5.setTitle("Moje wypieki i desery. Dla dzieci");
        book5.setCategory(Book.Category.BAKING);

        book5.setAuthor(author4);

        this.bookService.addBook(book1);
        this.bookService.addBook(book2);
        this.bookService.addBook(book3);
        this.bookService.addBook(book4);
        this.bookService.addBook(book5);

        return "redirect:/main";
    }
}
