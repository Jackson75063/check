package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.Book_author;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);

    public void updateBook(Book book);

    public void removeBook(int id);

    public Book getBookById(int id);

   public List<Book> listBooks();

    public List<Book> old1();

    public List<Book_author> task2();

    public String task4();

}
