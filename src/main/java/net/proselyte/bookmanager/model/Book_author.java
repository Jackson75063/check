package net.proselyte.bookmanager.model;

import javax.persistence.*;

/**
 * Created by Jackson on 13.10.2018.
 */

@Entity
@Table(name = "Book_author")

public class Book_author {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "author_id")
    private Integer author_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }
}
