package sahan.abr.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Schedule {
    private int id;
    private ScheduleRole role;
    private int idRole;
    private String date;
    private String sTime;
    private String eTime;

    public Schedule(ScheduleRole role, int idRole, String date, String sTime, String eTime) {
        this.role = role;
        this.idRole = idRole;
        this.date = date;
        this.sTime = sTime;
        this.eTime = eTime;
    }
}


