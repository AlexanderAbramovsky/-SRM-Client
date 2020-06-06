package sahan.abr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class Employee {

    private int id;
    private String surname;
    private String name;
    private String middleName;
    private String position;
    private String phoneNumber;
//    private HashMap<Integer, DateJobEmployee> timetable;

    public Employee() {
//        timetable = new HashMap<>();
//
//        timetable.put(1, null);
//        timetable.put(2, null);
//        timetable.put(3, null);
//        timetable.put(4, null);
//        timetable.put(5, null);
//        timetable.put(6, null);
//        timetable.put(7, null);

    }

    public Employee(String surname, String name, String middleName, String position, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;

//        timetable = new HashMap<>();
//
//        timetable.put(1, null);
//        timetable.put(2, null);
//        timetable.put(3, null);
//        timetable.put(4, null);
//        timetable.put(5, null);
//        timetable.put(6, null);
//        timetable.put(7, null);
    }
}
