package sahan.abr.TEST;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class VistaNavigator {

    public static final String MAIN    = "/main.fxml";
    public static final String TIMETABLE = "/timetable.fxml";
    public static final String EMPLOYEES = "/employees.fxml";
    public static final String VISTA2 = "/t2.fxml";

    private static MainController mainController;


    public static void setMainController(MainController mainController) {
        VistaNavigator.mainController = mainController;
    }


    public static void loadVista(String fxml) {
        try {
            mainController.setVista(FXMLLoader.load(VistaNavigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}