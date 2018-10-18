package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.AuthorDao;
import net.proselyte.bookmanager.dao.BookDao;
import net.proselyte.bookmanager.model.Author;
import net.proselyte.bookmanager.model.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jackson on 30.09.2018.
 */
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;
    private BookDao bookDao;

    public void setAuthorDao(AuthorDao authorDao){
        this.authorDao = authorDao;
    }


    @Override
    @Transactional
    public void addAuthor(Author author) {
        this.authorDao.addAuthor(author);
    }

    @Override
    @Transactional
    public void updateAuthor(Author author) {
        this.authorDao.addAuthor(author);
    }

    @Override
    @Transactional
    public void removeAuthor(int id) {
        this.authorDao.removeAuthor(id);
    }

    @Override
    public Author getAuthorById(int id) {
        return this.authorDao.getAuthorById(id);
    }


    @Override
    @Transactional
    public List<Author> listAuthors() {
        return this.authorDao.listAuthors();
    }


    @Override
    @Transactional
    public List<Author> task1() {
        return this.authorDao.task1();
    }

    @Override
    @Transactional
    public List<Author> task3() {
        return this.authorDao.task3();
    }





}
