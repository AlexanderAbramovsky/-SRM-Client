package sahan.abr.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static sahan.abr.Main.MAIN_STAGE;

public class Navigator {

    public static final String MAIN = "/fxml/main.fxml";

    public static final String SUBSCRIPTION = "/fxml/subscription/subscription.fxml";
    public static final String TIMETABLE = "/fxml/timetable.fxml";
    public static final String EMPLOYEE = "/fxml/employee/employee.fxml";
    public static final String VISTA2 = "/fxml/t2.fxml";

    public static final String MODAL_ADD_SUBSCRIPTION = "/fxml/subscription/add-subscription.fxml";
    public static final String MODAL_UPDATE_SUBSCRIPTION = "/fxml/subscription/update-subscription.fxml";
    public static final String MODAL_ADD_EMPLOYEE = "/fxml/employee/add-employee.fxml";
    public static final String MODAL_UPDATE_EMPLOYEE = "/fxml/employee/update-employee.fxml";

    private static MainController mainController;


    public static void setMainController(MainController mainController) {
        Navigator.mainController = mainController;
    }

    public static void getModalWindow(String title, String fxml) {
        try {

            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
            Stage newWindow = new Stage(StageStyle.DECORATED);
            newWindow.setTitle(title);

            newWindow.setScene(new Scene(loader.load()));
            newWindow.setResizable(false);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);

            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(MAIN_STAGE);

            // Set position of second window, related to primary window.
            newWindow.setX(MAIN_STAGE.getX() + 200);
            newWindow.setY(MAIN_STAGE.getY() + 100);

            newWindow.show();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static boolean getModalWindow(String title, String fxml, Object controller) {
        try {

            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(fxml));
            Stage newWindow = new Stage(StageStyle.DECORATED);
            newWindow.setTitle(title);

            loader.setController(controller);

            newWindow.setScene(new Scene(loader.load()));
            newWindow.setResizable(false);

            // Specifies the modality for new window.
            newWindow.initModality(Modality.WINDOW_MODAL);

            // Specifies the owner Window (parent) for new window
            newWindow.initOwner(MAIN_STAGE);

            // Set position of second window, related to primary window.
            newWindow.setX(MAIN_STAGE.getX() + 200);
            newWindow.setY(MAIN_STAGE.getY() + 100);

            newWindow.show();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return true;
    }

    public static void loadVista(String fxml) {
        try {
            mainController.setVista(FXMLLoader.load(Navigator.class.getResource(fxml)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}