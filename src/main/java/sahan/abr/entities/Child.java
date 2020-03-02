package sahan.abr.entities;

import java.util.HashMap;

public class Child {

    private Integer id;
    private String surname;
    private String name;
    private String shortName;
    private String middleName;
    private String gender;
    private String dateOfBirth;
    private String[] certificateValidityDate;
    private String note;

    // Все что относится к абонементу
    private Subscription subscription;
    private int numberOfLessonsRemaining;
    private String[] subscriptionValidity;

    private boolean actionSubscription;
    private String causeOfFreezing;
    private String[] subscriptionValidityFreezing;

    // Все что относится к тренеру
    private Employee trainer;

    //Все что относится к расписанию
    private HashMap<Integer, DateVisitCustomer> timetable;


    public Child() {
    }

    public Child(Integer id, String surname, String name,
                 String shortName, String middleName,
                 String gender, String dateOfBirth,
                 String[] certificateValidityDate, String note,
                 Subscription subscription, int numberOfLessonsRemaining,
                 String[] subscriptionValidity, boolean actionSubscription,
                 String causeOfFreezing, String[] subscriptionValidityFreezing) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.shortName = shortName;
        this.middleName = middleName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.certificateValidityDate = certificateValidityDate;
        this.note = note;
        this.subscription = subscription;
        this.numberOfLessonsRemaining = numberOfLessonsRemaining;
        this.subscriptionValidity = subscriptionValidity;
        this.actionSubscription = actionSubscription;
        this.causeOfFreezing = causeOfFreezing;
        this.subscriptionValidityFreezing = subscriptionValidityFreezing;
    }

    public Employee getTrainer() {
        return trainer;
    }

    public void setTrainer(Employee trainer) {
        this.trainer = trainer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String[] getCertificateValidityDate() {
        return certificateValidityDate;
    }

    public void setCertificateValidityDate(String[] certificateValidityDate) {
        this.certificateValidityDate = certificateValidityDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public int getNumberOfLessonsRemaining() {
        return numberOfLessonsRemaining;
    }

    public void setNumberOfLessonsRemaining(int numberOfLessonsRemaining) {
        this.numberOfLessonsRemaining = numberOfLessonsRemaining;
    }

    public String[] getSubscriptionValidity() {
        return subscriptionValidity;
    }

    public void setSubscriptionValidity(String[] subscriptionValidity) {
        this.subscriptionValidity = subscriptionValidity;
    }

    public boolean isActionSubscription() {
        return actionSubscription;
    }

    public void setActionSubscription(boolean actionSubscription) {
        this.actionSubscription = actionSubscription;
    }

    public String getCauseOfFreezing() {
        return causeOfFreezing;
    }

    public void setCauseOfFreezing(String causeOfFreezing) {
        this.causeOfFreezing = causeOfFreezing;
    }

    public String[] getSubscriptionValidityFreezing() {
        return subscriptionValidityFreezing;
    }

    public void setSubscriptionValidityFreezing(String[] subscriptionValidityFreezing) {
        this.subscriptionValidityFreezing = subscriptionValidityFreezing;
    }
}
