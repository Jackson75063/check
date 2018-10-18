package net.proselyte.bookmanager.service;

import net.proselyte.bookmanager.model.Author;
import net.proselyte.bookmanager.model.Book;

import java.util.List;

/**
 * Created by Jackson on 30.09.2018.
 */
public interface AuthorService {

     void addAuthor(Author author);

     void updateAuthor(Author author);

     void removeAuthor(int id);

     Author getAuthorById(int id);

     List<Author> listAuthors();

     List<Author> task1();

     List<Author> task3();



}
