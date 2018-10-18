package net.proselyte.bookmanager.dao;

import net.proselyte.bookmanager.model.Author;
import net.proselyte.bookmanager.model.Book;
import net.proselyte.bookmanager.model.Book_author;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Jackson on 30.09.2018.
 */
public class AuthorDaoImpl implements AuthorDao {

//    @Override
    //task3
//    public List<Author> task3() {
//        Session session = sessionFactory.openSession();
//        List list = session.createSQLQuery("select a.id,max(a.books) from (SELECT   a.id, COUNT(*) books\n" +
//                "FROM     author a\n" +
//                "JOIN     book_author ba ON a.id = ba.author_id\n" +
//                "GROUP BY a.id\n" +
//                "ORDER BY 2 DESC) as a").list();
//        List<Author> authors = new ArrayList<Author>();
//        for (Object info: list) {
//            Author author = getAuthorById((Integer) info[0]);
//            authors.add(author);
//        }
//        return authors;
//    }

//    task
//    @Query(value = "SELECT GROUP_CONCAT(b.id) AS book FROM books b INNER JOIN author_book ab ON b.id = ab.book_id INNER JOIN authors a ON ab.author_id = a.id GROUP BY a.id HAVING COUNT(author_id) > 1;", nativeQuery = true)
//    List<String> findBooksWhoseAuthorHasMoreOne();
//
//    task4
//    @Query(value = "SELECT books.genre, COUNT(*) AS count FROM books  GROUP BY genre", nativeQuery = true)
//    Set<Object> findNumberOfBooksByGenre();


//    task+1



    /*public List<Author> MostBooksAuthor() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select ab.author.id,a.name,count(ab.book.id) as coun from AuthorBook ab join Authors a on ab.author.id=a.id group by ab.author.id order by coun desc");
        query.setMaxResults(2);
        List result = query.list();

        return result;
    }*/


//    @Query("from Author where born<=:date order by born desc")
//    List<Author> sortByAge(@Param("date") Date date);


    /*public List MostBooksAuthor() {
        List author = null;
        try {
            author = jdbcTemplate.queryForList("select ab.author_id,a.name,count(ab.author_id) as coun from author_author ab join authors a on ab.author_id=a.id group by ab.author_id order by coun desc limit 2");
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return author;
    }*/

    /*

     public List<Authors> MostBooksAuthor() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select ab.author.id,a.name,count(ab.book.id) as coun from AuthorBook ab join Authors a on ab.author.id=a.id group by ab.author.id order by coun desc");
        query.setMaxResults(2);
        List result = query.list();

        return result;
    }

     */


    public List task4() {
      /*  Session session = this.sessionFactory.getCurrentSession();

        String sql = "SELECT books.genre, COUNT(*) AS count FROM books  GROUP BY genre";
        SQLQuery query= session.createSQLQuery(sql);
        query.addEntity(Book.class);

        List<Author> authorList1 = query.list();
        return authorList1;
*/

return null;

    }


    public List getBooksNameFromAuthor() {
       /* Session session = this.sessionFactory.getCurrentSession();

        String sql = "select a.name, group_concat(b.name separator ', '), count(ab.author_id) as counta from author_book ab  inner join Authors a on ab.author_id=a.id join Books b on ab.book_id=b.id group by ab.author_id having counta > 1";
        SQLQuery query= session.createSQLQuery(sql);
        query.addEntity(Author.class);




        List<Author> authorList1 = query.list();*/
        return null;

    }


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addAuthor(Author author) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(author);
//        session.save(author);
    }

    @Override
    public void updateAuthor(Author author) {

        Session session = this.sessionFactory.getCurrentSession();
        session.update(author);
    }

    @Override
    public void removeAuthor(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Author author = (Author) session.load(Author.class, new Integer(id));

        if(author!=null){
            session.delete(author);
        }
    }

    @Override
    public Author getAuthorById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Author author = (Author) session.load(Author.class, new Integer(id));
        return author;
    }

    @Override
    public List<Author> listAuthors() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Author> authorList= session.createQuery("FROM Author").list();

        return authorList;
    }

    @Override
    public List<Author> task1() {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM Author a WHERE year(current_date())- year(a.born)>55 ORDER BY a.born";

        SQLQuery query= session.createSQLQuery(sql);
        query.addEntity(Author.class);

        List<Author> authorList1   = query.list();

       return authorList1;
    }



    @Override
    public List<Author> task3() {


        Session session = this.sessionFactory.getCurrentSession();
        String sql = "SELECT sombra.author.*  FROM author, book_author WHERE author.id  = book_author.book_id GROUP BY name ORDER BY COUNT(*) DESC limit 1";

        SQLQuery query= session.createSQLQuery(sql);
        query.addEntity(Author.class);

        List<Author> authorList1   = query.list();

        return authorList1;
    }
}
