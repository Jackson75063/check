//import net.proselyte.bookmanager.model.Book;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.internal.SessionFactoryImpl;
//
//import java.util.List;
//
///**
// * Created by Jackson on 29.09.2018.
// */
//public class main {
//
//
//    public SessionFactory sessionFactory;
//
//
//    @SuppressWarnings("unchecked")
//    public List<Book> old1() {
//        Session session = this.sessionFactory.getCurrentSession();
////        List<Book> bookListt = session.createQuery("SELECT BOOK_TITLE, BOOK_AUTHOR, birthday FROM bookmanager.books WHERE birthday <= DATE_SUB(CURDATE(), INTERVAL 15 year)").list();
//        List<Book> bookList1 = session.createSQLQuery("SELECT BOOK_TITLE, BOOK_AUTHOR, birthday FROM bookmanager.books WHERE birthday <= DATE_SUB(CURDATE(), INTERVAL 15 year)").list();
//
//
//        return bookList1;
//    }
//
//
//
//
//
//
//    public static void main(String[] args) {
//
//
//        Session session = sessionFactory.getCurrentSession();
//        //        List<Book> bookListt = session.createQuery("SELECT BOOK_TITLE, BOOK_AUTHOR, birthday FROM bookmanager.books WHERE birthday <= DATE_SUB(CURDATE(), INTERVAL 15 year)").list();
//        List<Book> bookList1 = session.createSQLQuery("SELECT BOOK_TITLE, BOOK_AUTHOR, birthday FROM bookmanager.books WHERE birthday <= DATE_SUB(CURDATE(), INTERVAL 15 year)").list();
//
//
//        for(Book b:bookList1) {
//        }
//        System.out.println(bookList1.toString());
//        }
//
//    }
//
