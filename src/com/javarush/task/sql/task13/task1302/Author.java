package com.javarush.task.sql.task13.task1302;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "full_name")
    private String fullName;

    //напишите тут ваш код
    @ElementCollection // говорит о том что это коллекция
    @CollectionTable(name="author_achievement", // Указывает, в какой таблице хранится коллекция.
            // создаёт индекс на колонку achievement_index. Полезно для ускорения сортировки и поиска.
            indexes = { @Index(columnList = "achievements_index")},
            // колонка, по которой таблица связывается с author. Это внешний ключ на author.id.
    joinColumns = @JoinColumn(name = "author_id"))
    // указывает,в какой колонке хранится само значение элемента коллекции
    @Column(name = "achievement")
    private List<String> achievements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<String> achievements) {
        this.achievements = achievements;
    }
}
