package library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import library.dao.IAuthorDAO;
import library.model.Author;

import java.util.List;

@Repository
public class AuthorDAOImpl implements IAuthorDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Author> findAuthors(String pattern) {
        Session session = this.sessionFactory.openSession();
        Query<Author> query = session
                .createQuery("FROM library.model.Author WHERE name like :name OR surname like :surname");
        query.setParameter("name", "%" + pattern + "%");
        query.setParameter("surname", "%" + pattern + "%");
        List<Author> result = query.getResultList();
        session.close();
        return result;
    }
}
