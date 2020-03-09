package sahan.abr.service;


public class Subscription {

    private int id;
    private String firstName;


    protected Subscription() {
    }

    public Subscription(String firstName) {
        this.firstName = firstName;
    }

    public Subscription(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s']",
                id, firstName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
}