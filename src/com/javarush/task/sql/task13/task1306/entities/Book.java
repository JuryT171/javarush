package com.javarush.task.sql.task13.task1306.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    //напишите тут ваш код
    @ManyToMany(cascade = CascadeType.ALL) // много книг,много авторов
    @JoinTable(name="author_book", // имя промежуточной таблицы
            // колонка book_id в промежуточной таблице ссылается на id владельца
            joinColumns=  @JoinColumn(name="book_id", referencedColumnName="id"),
            // колонка author_id ссылается на id обратной стороны author
            inverseJoinColumns= @JoinColumn(name="author_id", referencedColumnName="id") )
    private Set<Author> authors;

    @Column(name = "publication_year")
    private Integer publicationYear;

    @Column(name = "isbn")
    private Long isbn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
