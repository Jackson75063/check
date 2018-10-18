package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.dao.AuthorDaoImpl;
import net.proselyte.bookmanager.dao.BookDao;
import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.Book_author;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private AuthorDaoImpl authorDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.updateBook(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.removeBook(id);
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return this.bookDao.getBookById(id);
    }

    @Override
    @Transactional
    public List<Book> listBooks() {
        return this.bookDao.listBooks();
    }


    @Override
    @Transactional
    public List<Book> old1() {
        return this.bookDao.old1();
    }

    @Override
    @Transactional
    public List<Book_author> task2() {
        return this.bookDao.task2();
    }


    public void setAuthorDao(AuthorDaoImpl authorDao) {
        this.authorDao = authorDao;
    }

    public AuthorDaoImpl getAuthorDao() {
        return authorDao;
    }
}
