package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Author;
import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.Book_author;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));

        if(book!=null){
            session.delete(book);
        }
    }

    @Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, new Integer(id));
        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();

//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 55);

        List<Book> bookList = session.createQuery("FROM Book").list();

//        List<Book> bookList = session.createCriteria(Book.class).add(Restrictions.le("born", calendar.getTime())).list();


        return bookList;
    }


    @Override
    public List<Book> old1() {
        Session session = this.sessionFactory.getCurrentSession();


//        List<Book> bookList1 = session.createCriteria(Book.class).add(Restrictions.le("born", calendar.getTime())).list();
//        List<Book> bookList1 = session.createQuery("SELECT ID, BOOK_TITLE, BOOK_AUTHOR, birthday FROM bookmanager.books WHERE birthday <= DATE_SUB(current_date , INTERVAL 15 year)").list();
//        List<Book> bookList1 = session.createQuery("from Book where born <= DATE_SUB(CURDATE(), INTERVAL 10 year)").list();

        List<Book> bookList1 = session.createSQLQuery("SELECT * FROM book ").list();

        return bookList1;
    }



    public List<Book> task3() {

/**

        Session session = this.sessionFactory.getCurrentSession();
//     wrong   String sql = "SELECT books.genre, COUNT(*) AS counter FROM books  GROUP BY genre";
//   work
        String sql = "SELECT b.genre as name, count(b.genre) as count from Books b group by b.genre";

        //try1
        //   String sql = "SELECT books.genre, COUNT(*) AS counter FROM books  GROUP BY genre";
        //try2
//        String sql = "SELECT b.genre as name, count(b.id) as count from Books b group by b.genre";




        SQLQuery query= session.createSQLQuery(sql);
        query.addEntity(Book.class);

        List<Book> authorList1   = query.list();

        return authorList1;
*/
        return null;

    }


    @Override
    public List<Book_author> task2()  {
        Session session = this.sessionFactory.getCurrentSession();

          String sql = "select a.author_id from book_author a  group by a.author_id   having COUNT(a.author_id) > 1  ";
          SQLQuery query = session.createSQLQuery(sql);
          query.addEntity(Book_author.class);

          List<Book_author> task2List = query.list();
          return task2List;
    }

    @Override
    public String task4() {
        return null;
    }
/*
    @Query(value = "SELECT authors.* FROM authors, author_book WHERE authors.id = author_book.author_id GROUP BY name ORDER BY COUNT(*) DESC LIMIT 1", nativeQuery = true)
    Author findAuthorWithMostBooks();*/



/*
* task 2
* SELECT sombra.author.*  FROM author, book_author WHERE author.id = book_author.`book-id` GROUP BY name ORDER BY COUNT(*) DESC
* */




/*by genre count
* SELECT b.genre as name, count(b.id) as count from Books b group by b.genre
* */

/*
books where uvtor >1 book
* select b.name from books b join book_author a  where a.author_id in
* (select a.author_id from book_author a group by a.author_id having COUNT(a.author_id) > 1)
* */

//    from Authors a where year(current_date())- year(a.born)>55 order by a.born

    /*
    * avtor the most books
    * SELECT a.name FROM authors a LEFT JOIN book_author b GROUP BY a.name ORDER BY COUNT(b.book_id) DESC limit 1
    * */




}
