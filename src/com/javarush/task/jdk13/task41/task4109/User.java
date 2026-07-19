package com.javarush.task.jdk13.task41.task4109;

public class User extends AbstractEntity {
    public String socialKey;
    public String secretKey;
    public String displayName;
    public String pictureUrl;
    public String sessionId;
    public String referenceKey;
    public int level;
    public int lesson;
    public int darkMatter;
    public int rating;
    public String email;
    public String country;
    public String city;
    public String statusMessage;

    public User() {
    }

    public User(User other) {
        super(other);
        this.socialKey = other.socialKey;
        this.secretKey = other.secretKey;
        this.displayName = other.displayName;
        this.pictureUrl = other.pictureUrl;
        this.sessionId = other.sessionId;
        this.referenceKey = other.referenceKey;
        this.level = other.level;
        this.lesson = other.lesson;
        this.darkMatter = other.darkMatter;
        this.rating = other.rating;
        this.email = other.email;
        this.country = other.country;
        this.city = other.city;
        this.statusMessage = other.statusMessage;
    }

    @Override
    public AbstractEntity clone() {   // ← возвращаем AbstractEntity
        return new User(this);
    }
}
