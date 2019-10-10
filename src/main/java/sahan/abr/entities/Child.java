package sahan.abr.entities;

public class Child {

    private Integer id;
    private String surname;
    private String name;
    private String middleName;

    //private Integer idSubscription;

    public Child() {
    }

    public Child(Integer id, String surname, String name, String middleName) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
