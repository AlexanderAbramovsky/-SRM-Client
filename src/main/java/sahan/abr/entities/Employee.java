package sahan.abr.entities;

import sahan.abr.lib.LibSRM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Employee {

    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String phoneNumber;
    private HashMap<Integer, DateJobEmployee> timetable;

    public Employee() {

        timetable = new HashMap<Integer, DateJobEmployee>();

        timetable.put(1, null);
        timetable.put(2, null);
        timetable.put(3, null);
        timetable.put(4, null);
        timetable.put(5, null);
        timetable.put(6, null);
        timetable.put(7, null);

    }

    public Employee(int id, String surname, String name, String middleName, String position, String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;

        timetable = new HashMap<Integer, DateJobEmployee>();

        timetable.put(1, null);
        timetable.put(2, null);
        timetable.put(3, null);
        timetable.put(4, null);
        timetable.put(5, null);
        timetable.put(6, null);
        timetable.put(7, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public HashMap<Integer, DateJobEmployee> getTimetable() {
        return timetable;
    }

    public void setTimetable(HashMap<Integer, DateJobEmployee> timetable) {
        this.timetable = timetable;
    }

    @Override
    public String toString()  {
        return LibSRM.getFIO(this);
    }
}
