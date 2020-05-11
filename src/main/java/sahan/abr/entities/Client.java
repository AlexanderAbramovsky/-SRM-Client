package sahan.abr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private int id;

    private int idChild;
    private int idPassport;
    private int idContract;

    private String surname;
    private String name;
    private String middleName;

    private String phoneNumber;
    private String contactPhoneNumber;

    public Client(int idChild, int idPassport, int idContract, String surname, String name, String middleName, String phoneNumber, String contactPhoneNumber) {
        this.idChild = idChild;
        this.idPassport = idPassport;
        this.idContract = idContract;
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    //TODO подумать на счет mail, vk и т.п.
}
