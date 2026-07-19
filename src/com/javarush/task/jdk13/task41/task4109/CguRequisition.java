package com.javarush.task.jdk13.task41.task4109;

public class CguRequisition extends RequisitionWithPhone {
    public String requestedSubscriptionType;
    public String language;

    public CguRequisition() {
    }

    public CguRequisition(CguRequisition other) {
        super(other);
        this.requestedSubscriptionType = other.requestedSubscriptionType;
        this.language = other.language;
    }

    @Override
    public AbstractEntity clone() {   // ← возвращаем AbstractEntity
        return new CguRequisition(this);
    }
}
