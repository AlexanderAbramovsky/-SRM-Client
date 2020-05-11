package sahan.abr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Child {
    private int id;
    private int idClient;
    private int idReference;
    private String surname;
    private String name;
    private String middleName;
    private Gender gender;
    private String dateOfBirth;
    private String note;

    public Child(int idClient, int idReference, String surname, String name, String middleName, Gender gender, String dateOfBirth, String note) {
        this.idClient = idClient;
        this.idReference = idReference;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.note = note;
    }
}
