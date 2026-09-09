package com.javarush.task.sql.task12.task1201;

import jakarta.persistence.*;

/* 
Создаём Entity из класса
*/

//напишите тут ваш код
@Entity
@Table(name = "library_table")
public class Library {
    //напишите тут ваш код
    @Id
    private Long id;
    @Enumerated(EnumType.ORDINAL) //значение будет сохранено в базу как число
    @Column(name = "status")
    private PublicationStatus status;
    @Column(name = "publicationName")
    private String publicationName;
    @Column(name = "isbn")
    private String isbn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PublicationStatus getStatus() {
        return status;
    }

    public void setStatus(PublicationStatus status) {
        this.status = status;
    }

    public String getPublicationName() {
        return publicationName;
    }

    public void setPublicationName(String publicationName) {
        this.publicationName = publicationName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
