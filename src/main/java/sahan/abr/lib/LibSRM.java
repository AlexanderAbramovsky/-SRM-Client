package sahan.abr.lib;

import sahan.abr.entities.Employee;
import sahan.abr.entities.Parent;

import java.util.Calendar;

public class LibSRM {

    public static String getDateStringFormat(Calendar calendar) {
        String day = ((calendar.get(Calendar.DAY_OF_MONTH) < 10) ? "0" : "") + calendar.get(Calendar.DAY_OF_MONTH);
        String month = (((calendar.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (calendar.get(Calendar.MONTH) + 1);
        String year = "" + calendar.get(Calendar.YEAR);
        String[] masYear = year.split("");
        year = masYear[masYear.length - 2] + masYear[masYear.length - 1];
        return day + "." + month + "." + year;
    }

    public static String getFIO(Employee employee) {
        return employee.getSurname() + " " + employee.getName().split("")[0]
                + "." + employee.getMiddleName().split("")[0];
    }

    public static String getFIO(Parent parent) {
        return parent.getSurname() + " " + parent.getName().split("")[0]
                + "." + parent.getMiddleName().split("")[0] + ".";
    }
}
