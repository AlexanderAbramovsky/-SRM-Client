package sahan.abr.entities;

import javafx.scene.image.Image;

public class Subscription {

    private int id;
    private String titleSubscription;
    private double priceSubscription;
    private int validity;
    private int numberClasses;

    public Subscription() {
    }

    public Subscription(int id, String titleSubscription, double priceSubscription, int validity, int numberClasses) {
        this.id = id;
        this.titleSubscription = titleSubscription;
        this.priceSubscription = priceSubscription;
        this.validity = validity;
        this.numberClasses = numberClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleSubscription() {
        return titleSubscription;
    }

    public void setTitleSubscription(String titleSubscription) {
        this.titleSubscription = titleSubscription;
    }

    public double getPriceSubscription() {
        return priceSubscription;
    }

    public void setPriceSubscription(double priceSubscription) {
        this.priceSubscription = priceSubscription;
    }

    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getNumberClasses() {
        return numberClasses;
    }

    public void setNumberClasses(int numberClasses) {
        this.numberClasses = numberClasses;
    }
}
