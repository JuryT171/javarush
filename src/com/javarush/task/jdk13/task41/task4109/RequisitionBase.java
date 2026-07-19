package com.javarush.task.jdk13.task41.task4109;

public abstract class RequisitionBase extends AbstractEntity {
    public User user;
    public String name;
    public String mail;
    public String utmMark;
    public String webinarType;
    public String promoCode;

    public RequisitionBase() {
    }

    public RequisitionBase(RequisitionBase other) {
        super(other);
        //Копируем user с помощью его метода clone()
        this.user = other.user != null ? (User) other.user.clone() : null;
        this.name = other.name;
        this.mail = other.mail;
        this.utmMark = other.utmMark;
        this.webinarType = other.webinarType;
        this.promoCode = other.promoCode;
    }
}
