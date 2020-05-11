package sahan.abr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contract {
    private int id;
    private int idClient;
    private String number;
    private String date;

    public Contract(int idClient, String number, String date) {
        this.idClient = idClient;
        this.number = number;
        this.date = date;
    }
}
