package sahan.abr.entities;

public class Employee {

    private int id;
    private String fio;
    private String position;
    private String phoneNumber;

    private boolean deleteEmployee;

    public Employee() {
    }

    public Employee(int id, String fio, String position, String phoneNumber) {
        this.id = id;
        this.fio = fio;
        this.position = position;
        this.phoneNumber = phoneNumber;
    }

    public boolean getDeleteEmployee() {
        return deleteEmployee;
    }

    public void setDeleteEmployee(boolean deleteEmployee) {
        this.deleteEmployee = deleteEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
