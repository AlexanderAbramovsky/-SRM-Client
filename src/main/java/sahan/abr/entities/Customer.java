package sahan.abr.entities;

import sahan.abr.lib.LibSRM;

public class Customer {
    private Parent parent;
    private Child2 child;

    private String fio;
    private String phoneNumber;
    private String shortNameChild = "�� ���������������";

    public Customer() {
    }

    public Customer(Parent parent) {
        this.parent = parent;

        fio = LibSRM.getFIO(parent);
        phoneNumber = parent.getPhoneNumber();
    }

    public Customer(Parent parent, Child2 child) {
        this.parent = parent;
        this.child = child;

        fio = LibSRM.getFIO(parent);
        phoneNumber = parent.getPhoneNumber();

        if (child != null) {
            shortNameChild = child.getShortName();
        }
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child2 getChildren() {
        return child;
    }

    public void setChildren(Child2 child) {
        this.child = child;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShortNameChild() {
        return shortNameChild;
    }

    public void setShortNameChild(String shortNameChild) {
        this.shortNameChild = shortNameChild;
    }
}

